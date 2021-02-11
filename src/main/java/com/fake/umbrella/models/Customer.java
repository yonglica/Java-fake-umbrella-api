package com.fake.umbrella.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Customers")
public class Customer {
  @Id
  private String id;
  private String name;
  private String personOfContact;
  private String telephoneNumber;
  private String location;
  private int numberOfEmployees;

//  public Customer(String id, String name, String personOfContact, String telephoneNumber, String location, int numberOfEmployees) {
//    this.id = id;
//    this.name = name;
//    this.personOfContact = personOfContact;
//    this.telephoneNumber = telephoneNumber;
//    this.location = location;
//    this.numberOfEmployees = numberOfEmployees;
//  }
//
//  public String getId() {
//    return id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public String getPersonOfContact() {
//    return personOfContact;
//  }
//
//  public void setPersonOfContact(String personOfContact) {
//    this.personOfContact = personOfContact;
//  }
//
//  public String getTelephoneNumber() {
//    return telephoneNumber;
//  }
//
//  public void setTelephoneNumber(String telephoneNumber) {
//    this.telephoneNumber = telephoneNumber;
//  }
//
//  public String getLocation() {
//    return location;
//  }
//
//  public void setLocation(String location) {
//    this.location = location;
//  }
//
//  public int getNumberOfEmployees() {
//    return numberOfEmployees;
//  }
//
//  public void setNumberOfEmployees(int numberOfEmployees) {
//    this.numberOfEmployees = numberOfEmployees;
//  }
//
//  @Override
//  public String toString() {
//    return "Customer{" +
//      "id='" + id + '\'' +
//      ", name='" + name + '\'' +
//      ", personOfContact='" + personOfContact + '\'' +
//      ", telephoneNumber='" + telephoneNumber + '\'' +
//      ", location='" + location + '\'' +
//      ", numberOfEmployees=" + numberOfEmployees +
//      '}';
//  }
}
