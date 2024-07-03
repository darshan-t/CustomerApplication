package com.example.CustomerApplication.controller;

import com.example.CustomerApplication.entity.Customer;
import com.example.CustomerApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
// instead of these two we can use :
//@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //By default it is get method
    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @RequestMapping("/customers/{id}")
    public Customer getCustomersById(@PathVariable Long id){
        return  customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    public void createCustomer(@RequestBody Customer customer){
          customerService.createCustomer(customer);
    }
    @RequestMapping(value = "/customers/{id}",method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer,@PathVariable Long id){
        customerService.updateCustomer(customer,id);
    }
    @RequestMapping(value = "/customers/{id}",method = RequestMethod.DELETE)
    public List<Customer> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return customerService.getAllCustomers();
    }
}
