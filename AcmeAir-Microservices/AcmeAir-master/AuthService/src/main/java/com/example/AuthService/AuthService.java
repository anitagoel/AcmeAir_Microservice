package com.example.AuthService;

import com.example.AuthService.dto.Customer;
import com.example.AuthService.dto.LoginDTO;
import com.example.AuthService.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginDTO loginDTO);
    Customer getCustomerByUserName(String username);

}
