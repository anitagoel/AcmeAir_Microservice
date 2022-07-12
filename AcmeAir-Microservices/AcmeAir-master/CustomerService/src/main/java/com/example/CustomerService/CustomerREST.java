package com.example.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerREST {

    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerREST(CustomerServiceImpl service){
        this.customerService=service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomers(){
        try{
            return ResponseEntity.ok(customerService.getAllCustomers());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerInfo customer){
        try{
            return ResponseEntity.ok(customerService.save(customer));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerInfo customer){
        try{
            return ResponseEntity.ok(customerService.update(customer));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
        try{
            return ResponseEntity.ok(customerService.delete(customerId));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/username/{username}")
    public CustomerDTO getByUsername(@PathVariable String username){
        try{
            return customerService.getCustomerByUsername(username);
        }catch (Exception e){
            return null;
        }
    }

}
