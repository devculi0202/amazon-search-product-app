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
public class RequestInfo {
  @JsonProperty("request_info")
  private Boolean success;
  @JsonProperty("credits_used")
  private Integer creditsUsed;
  @JsonProperty("credits_remaining")
  private Integer creditsRemaining;
  @JsonProperty("credits_used_this_request")
  private Integer  creditsUsedThisRequest;
}
