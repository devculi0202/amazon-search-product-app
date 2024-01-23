package com.devculi.application.amazon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestInfo {
  private Boolean success;
  private Integer creditsUsed;
  private Integer creditsRemaining;
  private Integer  creditsUsedThisRequest;
}
