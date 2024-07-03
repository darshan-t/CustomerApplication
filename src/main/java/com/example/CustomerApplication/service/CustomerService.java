package com.example.CustomerApplication.service;

import com.example.CustomerApplication.entity.Customer;
import com.example.CustomerApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);

    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer,Long id){
           customer.setId(id);

          customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
