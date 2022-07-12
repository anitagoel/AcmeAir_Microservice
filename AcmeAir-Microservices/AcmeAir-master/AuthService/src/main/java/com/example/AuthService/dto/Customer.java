package com.example.AuthService.dto;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean isVerified;
    private String roles;
}
