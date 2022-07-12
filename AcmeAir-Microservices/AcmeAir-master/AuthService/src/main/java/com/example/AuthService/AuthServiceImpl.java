package com.example.AuthService;

import com.example.AuthService.dto.Customer;
import com.example.AuthService.dto.LoginDTO;
import com.example.AuthService.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceImpl implements AuthService{

    private final RestTemplate restTemplate;
    private final AuthenticationManager authenticationManager;
    private final KeyGenerator keyGenerator;
    private final UserService userService;

    @Autowired
    public AuthServiceImpl(RestTemplate template,AuthenticationManager authenticationManager,KeyGenerator keyGenerator,UserService userService){
        this.restTemplate=template;
        this.authenticationManager=authenticationManager;
        this.keyGenerator=keyGenerator;
        this.userService=userService;
    }

    public LoginResponseDTO login(LoginDTO loginDTO) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );
        }catch (Exception e){
            return null;
        }
        final UserDetailsImpl userDetails = userService.loadUserByUsername(loginDTO.getUsername());
        String token = keyGenerator.generateToken(userDetails);
        return new LoginResponseDTO(loginDTO.getUsername(),token);
    }

    public Customer getCustomerByUserName(String username){
        Customer customer;
        customer = restTemplate.getForObject(
                "http://localhost:8081/customer/username/"+username
                ,Customer.class);
        return customer;
    }
}
