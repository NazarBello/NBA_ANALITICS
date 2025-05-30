package com.nazarbello.demo.service;
import com.nazarbello.demo.dto.JwtAuthenticationResponse;
import com.nazarbello.demo.dto.UserRegistrationDto;
import com.nazarbello.demo.dto.UserSignIn;
import com.nazarbello.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.nazarbello.demo.service.JwtService.TokenType.ACCESS;
import static com.nazarbello.demo.service.JwtService.TokenType.REFRESH;


@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationResponse signUp(UserRegistrationDto request) {

        var user  = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .build();

        userService.save(user);

        var accesssJwt = jwtService.generateToken(user, ACCESS);
        var refreshJwt = jwtService.generateToken(user,REFRESH );


        return new JwtAuthenticationResponse(accesssJwt, refreshJwt);
    }

    public JwtAuthenticationResponse signIn(UserSignIn request) {

       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
               request.getUsername(),
               request.getPassword()
       ));

       var user = userService
               .userDetailsService()
               .loadUserByUsername(request.getUsername());


        var accesssJwt = jwtService.generateToken(user, ACCESS);
        var refreshJwt = jwtService.generateToken(user,REFRESH );


       return new JwtAuthenticationResponse(accesssJwt, refreshJwt);
    }






}
