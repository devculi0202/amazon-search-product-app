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
public class Suggestions {
   @JsonProperty("suggType")
   private String suggType;
   @JsonProperty("type")
   private String type;
   @JsonProperty("value")
   private String value;
   @JsonProperty("refTag")
   private String refTag;
   @JsonProperty("candidateSources")
   private String candidateSources;
   @JsonProperty("strategyId")
   private String strategyId;
   @JsonProperty("strategyApiType")
   private String strategyApiType;
   @JsonProperty("prior")
   private String prior;
   @JsonProperty("ghost")
   private String ghost;
   @JsonProperty("help")
   private String help;
}
