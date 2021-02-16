package com.fake.umbrella.configuration;

import com.fake.umbrella.services.OpenWeatherService;
import com.fake.umbrella.services.WeatherForecastService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
  }

  @Bean
  public WeatherForecastService weatherForecastService() {
    return new WeatherForecastService();
  }

  @Bean
  public OpenWeatherService openWeatherService() {
    return new OpenWeatherService();
  }

}
