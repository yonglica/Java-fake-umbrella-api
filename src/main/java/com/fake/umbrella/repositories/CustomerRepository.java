package com.fake.umbrella.repositories;

import com.fake.umbrella.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
