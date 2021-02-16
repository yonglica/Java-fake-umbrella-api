package com.fake.umbrella.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customers")
public class Customer {
  private String name;
  private String personOfContact;
  private String telephoneNumber;
  private String location;
  private int numberOfEmployees;
  @Id
  private String id;

}
