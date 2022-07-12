package com.example.CustomerService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLoader extends JpaRepository<CustomerInfo,Long> {
    CustomerInfo findCustomerInfoById(Long id);

    CustomerInfo findCustomerInfoByUsername(String username);
}
