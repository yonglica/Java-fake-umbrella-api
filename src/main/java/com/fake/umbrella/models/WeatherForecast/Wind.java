package com.fake.umbrella.models.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "speed",
  "deg"
})
public class Wind {
  @JsonProperty("speed")
  public Double speed;
  @JsonProperty("deg")
  public Integer deg;
}
