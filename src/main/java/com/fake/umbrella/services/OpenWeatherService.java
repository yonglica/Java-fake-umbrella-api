package com.fake.umbrella.services;

import com.fake.umbrella.models.WeatherForecast.WeatherForecast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OpenWeatherService {

  @Value("${weather.api.key}")
  private String API_KEY;

  @Value("${weather.api.url}")
  private String API_URL;

  @Autowired
  private RestTemplate restTemplate;

  public WeatherForecast getWeatherForecastByCityNameAndCountryCode(String cityName, String countryCode) {
    final String endpoint = String.format(API_URL, cityName, countryCode, API_KEY);
    log.debug("Weather API endpoint: " + endpoint);

    try {
      WeatherForecast weatherForecast = restTemplate.getForObject(endpoint, WeatherForecast.class);
      log.info("Weather forecast retrieved: " + weatherForecast);
      return weatherForecast;
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return null;
  }

}
