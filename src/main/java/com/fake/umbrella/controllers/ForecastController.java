package com.fake.umbrella.controllers;

import com.fake.umbrella.models.CustomerForecast;
import com.fake.umbrella.services.WeatherForecastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ForecastController {

  private static final Logger logger = LoggerFactory.getLogger(ForecastController.class);

  @Autowired
  private WeatherForecastService weatherForecastService;

  @GetMapping(value = "forecast")
  public List<CustomerForecast> getCustomerForecast() {
    return weatherForecastService.getWeatherForecast();
  }

  @GetMapping(value = "report")
  public List<CustomerForecast> getTopReport(@RequestParam("top") int top) {
    logger.info(String.format("Request weather forecast report for top %d customers", top));
    return weatherForecastService.getTopReport(top);
  }
}
