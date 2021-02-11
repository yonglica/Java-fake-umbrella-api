package com.fake.umbrella.controllers;

import com.fake.umbrella.models.Customer;
import com.fake.umbrella.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping
  public List<Customer> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    logger.info("retrieved all customers: " + customers.size());
    return customers;
  }

  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer) {
    logger.info("add new customer");
    return customerRepository.save(customer);
  }

  @GetMapping
  @RequestMapping("{id}")
  public Optional<Customer> getCustomerById(@PathVariable String id) {
    logger.info("retrieve customer by ID: " + id);
    return customerRepository.findById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void deleteCustomer(@PathVariable("id") String id) {
    logger.info("delete customer by ID: " + id);
    customerRepository.deleteById(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public void updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
    logger.info("update customer by ID: " + id);
    customer.setId(id);
    customerRepository.save(customer);
  }
}
