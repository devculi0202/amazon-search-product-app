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
  @JsonProperty("alias")
  String alias;
  @JsonProperty("prefix")
  String prefix;
  @JsonProperty("suffix")
  String suffix;
  @JsonProperty("suggestions")
  List<Suggestions> suggestions;
}
