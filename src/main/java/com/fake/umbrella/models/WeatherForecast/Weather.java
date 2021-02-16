package com.fake.umbrella.models.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "id",
  "main",
  "description",
  "icon"
})
public class Weather {
  @JsonProperty("id")
  public Integer id;
  @JsonProperty("main")
  public String main;
  @JsonProperty("description")
  public String description;
  @JsonProperty("icon")
  public String icon;
}
