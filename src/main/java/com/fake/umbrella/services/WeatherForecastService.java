package com.fake.umbrella.services;

import com.fake.umbrella.models.Customer;
import com.fake.umbrella.models.CustomerForecast;
import com.fake.umbrella.models.WeatherForecast.Weather;
import com.fake.umbrella.models.WeatherForecast.WeatherForecast;
import com.fake.umbrella.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WeatherForecastService {

  @Autowired
  private OpenWeatherService openWeatherService;

  @Autowired
  private CustomerRepository customerRepository;

  public List<CustomerForecast> getWeatherForecast() {
    List<Customer> customers = customerRepository.findAll();
    return getForecastList(customers);
  }

  public List<CustomerForecast> getTopReport(int top) {
    List<Customer> customers = customerRepository.findByOrderByNumberOfEmployeesDesc();
    int min = Integer.min(top, customers.size());
    return getForecastList(customers.subList(0, min));
  }

  private List<CustomerForecast> getForecastList(List<Customer> customers) {
    List<CustomerForecast> customerForecasts = new ArrayList<>();
    for (Customer customer : customers) {
      String[] locationArray = customer.getLocation().split(",");
      String cityName = locationArray[0];
      String countryCode = locationArray[1];

      log.info("try to retrieve weather forecast for " + cityName + "," + countryCode);
      WeatherForecast weatherForecast = openWeatherService.getWeatherForecastByCityNameAndCountryCode(cityName, countryCode);

      List<String> rainyDays = getRainyDays(weatherForecast);

      CustomerForecast customerForecast = new CustomerForecast();
      customerForecast.setName(customer.getName());
      customerForecast.setPersonOfContact(customer.getPersonOfContact());
      customerForecast.setTelephoneNumber(customer.getTelephoneNumber());
      customerForecast.setLocation(customer.getLocation());
      customerForecast.setNumberOfEmployees(customer.getNumberOfEmployees());
      customerForecast.setRainDates(rainyDays);
      customerForecast.setRainInFiveDays(rainyDays.isEmpty() ? false : true);
      customerForecasts.add(customerForecast);
    }
    return customerForecasts;
  }

  private List<String> getRainyDays(WeatherForecast weatherForecast) {
    List<String> rainyDays = new ArrayList<>();
    for (com.fake.umbrella.models.WeatherForecast.List list : weatherForecast.list) {
      for (Weather weather : list.weather) {
        if (weather.main.equalsIgnoreCase("Rain")) {
          rainyDays.add(list.dtTxt);
        }
      }
    }
    return rainyDays;
  }

}
