package com.example.AuthService;

import com.example.AuthService.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                try{
                    Customer customer =  restTemplate.getForObject(
                            "http://localhost:8081/customer/username/"+username
                            ,Customer.class);
                    if(customer!=null) return new UserDetailsImpl(customer);
                    else return null;
                }catch (Exception e){
                    return null;
                }
            }
        };
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Customer customer =  restTemplate.getForObject(
                    "http://localhost:8081/customer/username/"+username
                    ,Customer.class);
            if(customer!=null) return new UserDetailsImpl(customer);
            else return null;
        }catch (Exception e){
            return null;
        }
    }
}
