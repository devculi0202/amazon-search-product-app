package com.devculi.application.amazon.domain.autocomplete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestMetadata {
  @JsonProperty("created_at")
  private String createAt;
  @JsonProperty("processed_at")
  private String processedAt;
  @JsonProperty("total_time_taken")
  private Float totalTimeTaken;


}
