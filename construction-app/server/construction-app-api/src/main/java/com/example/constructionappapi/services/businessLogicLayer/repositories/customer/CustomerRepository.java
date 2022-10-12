package com.example.constructionappapi.services.businessLogicLayer.repositories.customer;

import com.example.constructionappapi.services.dataAccessLayer.dao.CustomerDao;
import com.example.constructionappapi.services.dataAccessLayer.entities.CustomerEntity;
import com.example.constructionappapi.services.dataAccessLayer.entities.CustomerNoteEntity;
import com.example.constructionappapi.services.dataAccessLayer.entities.WorkEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class accessing the customer table in DB
 */
@Service
public class CustomerRepository implements ICustomerRepository {

    private CustomerDao customerDao;

    public CustomerRepository(CustomerDao CustomerDao) {
        this.customerDao = CustomerDao;
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        for (WorkEntity work : customer.getWorkList()) {
            work.setCustomer(customer);
        }

        for (CustomerNoteEntity customerNoteEntity : customer.getCustomerNotes()) {
            customerNoteEntity.setCustomer(customer);
        }

        return customerDao.save(customer);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Optional<CustomerEntity> getCustomer(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }
}