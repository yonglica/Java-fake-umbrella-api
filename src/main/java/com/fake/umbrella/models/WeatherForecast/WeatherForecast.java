package com.fake.umbrella.models.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "cod",
  "message",
  "cnt",
  "list",
  "city"
})
public class WeatherForecast {
  @JsonProperty("cod")
  public String cod;
  @JsonProperty("message")
  public Integer message;
  @JsonProperty("cnt")
  public Integer cnt;
  @JsonProperty("list")
  public java.util.List<List> list;
  @JsonProperty("city")
  public City city;
}


















