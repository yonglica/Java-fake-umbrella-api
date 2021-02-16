package com.fake.umbrella.models;

import lombok.Data;

import java.util.List;

@Data
public class CustomerForecast extends Customer {
  private List<String> rainDates;
  private boolean rainInFiveDays;
}
