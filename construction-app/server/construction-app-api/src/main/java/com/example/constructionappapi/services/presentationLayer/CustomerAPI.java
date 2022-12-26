package com.example.constructionappapi.services.presentationLayer;

import com.example.constructionappapi.services.businessLogicLayer.repositories.CustomerRepository;
import com.example.constructionappapi.services.dataAccessLayer.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerAPI {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/kunder")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        return customerRepository.createCustomer(customer);
    }

    @GetMapping("/kunder/{id}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable final Long id) {
        return customerRepository.getCustomer(id);
    }

    @GetMapping("/kunder")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @DeleteMapping("/kunder/{id}/remove")
    public ResponseEntity<String> deleteCustomer(@PathVariable final Long id) {
        return customerRepository.deleteCustomer(id); // Ska det vara return här?
    }
}
