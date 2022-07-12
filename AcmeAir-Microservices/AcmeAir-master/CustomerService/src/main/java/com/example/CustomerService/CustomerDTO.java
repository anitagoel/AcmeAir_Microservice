package com.example.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean isVerified;

    private String roles;

    public CustomerDTO(CustomerInfo customerInfo){
        this.id= customerInfo.getId();
        this.name=customerInfo.getName();
        this.username=customerInfo.getUsername();
        this.email=customerInfo.getEmail();
        this.password=customerInfo.getPassword();
        this.isVerified=customerInfo.getIsVerified();
        this.roles=customerInfo.getRoles();
    }
}
