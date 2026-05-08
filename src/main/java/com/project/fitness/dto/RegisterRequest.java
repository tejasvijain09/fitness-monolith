package com.project.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest { // Yeh class user registration ka input represent karti hai

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}

//Yeh sab woh data hai jo client (React/Postman) bhejega

// Spring automatically converts JSON request body into Java objects using Jackson.
