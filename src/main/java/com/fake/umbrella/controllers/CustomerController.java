package com.fake.umbrella.controllers;

import com.fake.umbrella.models.Customer;
import com.fake.umbrella.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping
  public List<Customer> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    log.info("retrieved all customers: " + customers.size());
    return customers;
  }

  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer) {
    log.info("add new customer");
    return customerRepository.save(customer);
  }

  @GetMapping
  @RequestMapping(value ="{id}")
  public Optional<Customer> getCustomerById(@PathVariable String id) {
    log.info("retrieve customer by ID: " + id);
    return customerRepository.findById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void deleteCustomer(@PathVariable("id") String id) {
    log.info("delete customer by ID: " + id);
    customerRepository.deleteById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public void updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
    log.info("update customer by ID: " + id);
    customer.setId(id);
    customerRepository.save(customer);
  }
}
