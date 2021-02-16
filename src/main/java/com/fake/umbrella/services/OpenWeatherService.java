package com.fake.umbrella.services;

import com.fake.umbrella.models.WeatherForecast.WeatherForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherService {

  private static final Logger logger = LoggerFactory.getLogger(OpenWeatherService.class);

  @Value("${weather.api.key}")
  private String API_KEY;

  @Value("${weather.api.url}")
  private String API_URL;

  @Autowired
  private RestTemplate restTemplate;

  public WeatherForecast getWeatherForecastByCityNameAndCountryCode(String cityName, String countryCode) {
    final String endpoint = String.format(API_URL, cityName, countryCode, API_KEY);
    logger.debug("Weather API endpoint: " + endpoint);

    try {
      WeatherForecast weatherForecast = restTemplate.getForObject(endpoint, WeatherForecast.class);
      logger.info("Weather forecast retrieved: " + weatherForecast);
      return weatherForecast;
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return null;
  }

}
