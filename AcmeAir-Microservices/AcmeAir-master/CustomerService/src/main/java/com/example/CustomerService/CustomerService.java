package com.example.CustomerService;

import java.util.List;

public interface CustomerService {
    List<CustomerInfo> getAllCustomers();

    CustomerInfo save(CustomerInfo customer);

    CustomerInfo update(CustomerInfo customer);

    CustomerInfo delete(Long customerId);

    CustomerDTO getCustomerByUsername(String username);
}
