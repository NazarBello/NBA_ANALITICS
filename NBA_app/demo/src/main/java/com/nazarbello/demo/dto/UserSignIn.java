package com.nazarbello.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object for user sign-in credentials.
 * Contains validated username and password fields.
 */
@Data
@Schema(description = "User sign IN")
public class UserSignIn {

    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters")
    @Schema(description = "Username", example = "John")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Schema(description = "Password", example = "my_1secret1_password")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
