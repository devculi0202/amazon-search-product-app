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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestParameters {
  @JsonProperty("type")
  private String type;
  @JsonProperty("amazon_domain")
  private String amazonDomain;
  @JsonProperty("search_term")
  private String searchTerm;
}
