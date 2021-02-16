package com.fake.umbrella.repositories;

import com.fake.umbrella.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  List<Customer> findByOrderByNumberOfEmployeesDesc();

}
