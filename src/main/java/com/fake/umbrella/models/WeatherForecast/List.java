package com.fake.umbrella.models.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "dt",
  "main",
  "weather",
  "clouds",
  "wind",
  "visibility",
  "pop",
  "sys",
  "dt_txt",
  "rain"
})
public class List {
  @JsonProperty("dt")
  public Integer dt;
  @JsonProperty("main")
  public Main main;
  @JsonProperty("weather")
  public java.util.List<Weather> weather;
  @JsonProperty("clouds")
  public Clouds clouds;
  @JsonProperty("wind")
  public Wind wind;
  @JsonProperty("visibility")
  public Integer visibility;
  @JsonProperty("pop")
  public Double pop;
  @JsonProperty("sys")
  public Sys sys;
  @JsonProperty("dt_txt")
  public String dtTxt;
  @JsonProperty("rain")
  public Rain rain;
}
