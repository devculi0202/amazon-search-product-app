package com.devculi.application.amazon.domain.autocomplete;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class AmazonAutoComplete {
  @JsonProperty("request_info")
  RequestInfo requestInfo;
  @JsonProperty("request_parameters")
  RequestParameters requestParameters;
  @JsonProperty("request_metadata")
  RequestMetadata requestMetadata;
  @JsonProperty("autocomplete_results")
  List<AutoCompleteResults> autoCompleteResults;
}
