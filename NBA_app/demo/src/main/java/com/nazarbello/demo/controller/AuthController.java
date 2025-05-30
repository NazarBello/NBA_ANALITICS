package com.nazarbello.demo.controller;

import com.nazarbello.demo.dto.JwtAuthenticationResponse;
import com.nazarbello.demo.dto.UserRegistrationDto;
import com.nazarbello.demo.dto.UserSignIn;
import com.nazarbello.demo.service.AuthentificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Authentication")
public class AuthController {
    private final AuthentificationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid UserRegistrationDto request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "User sign-in", description = "Authenticates user and returns JWT token")
    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody @Valid UserSignIn request) {
        try {
            JwtAuthenticationResponse response = authenticationService.signIn(request);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Authentication error: " + e.getMessage());
        }
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + e.getMessage());
    }
}
