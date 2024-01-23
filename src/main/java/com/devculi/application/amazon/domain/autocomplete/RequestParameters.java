package com.devculi.application.amazon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestParameters {
  private String type;
  private String amazonDomain;
  private String searchTerm;
}
