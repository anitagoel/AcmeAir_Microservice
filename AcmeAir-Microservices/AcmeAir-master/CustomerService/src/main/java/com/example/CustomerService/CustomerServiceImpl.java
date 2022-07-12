package com.example.CustomerService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerLoader repo;

    public CustomerServiceImpl(CustomerLoader loader){
        this.repo=loader;
    }

    @Override
    public List<CustomerInfo> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public CustomerInfo save(CustomerInfo customer) {
        return repo.save(customer);
    }

    @Override
    public CustomerInfo update(CustomerInfo customer) {
        CustomerInfo newCustomer = repo.findCustomerInfoById(customer.getId());
        customer.setEmail(customer.getEmail()==null? newCustomer.getEmail() : customer.getEmail());
        customer.setName(customer.getName()==null?newCustomer.getName():customer.getName());
        customer.setUsername(customer.getUsername()==null?newCustomer.getUsername(): customer.getUsername());
        customer.setAddressInfo(customer.getAddressInfo()==null?newCustomer.getAddressInfo():customer.getAddressInfo());
        return repo.save(customer);
    }

    @Override
    public CustomerInfo delete(Long customerId) {
        CustomerInfo customerInfo=repo.findCustomerInfoById(customerId);
        repo.delete(customerInfo);
        return customerInfo;
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) {
        CustomerInfo customerInfo=repo.findCustomerInfoByUsername(username);
        return new CustomerDTO(customerInfo);
    }
}
