package com.project.fitness.dto;

import com.project.fitness.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest { // Yeh class user registration ka input represent karti hai

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;
}

//Yeh sab woh data hai jo client (React/Postman) bhejega

// Spring automatically converts JSON request body into Java objects using Jackson.
