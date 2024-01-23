package com.devculi.application.amazon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestMetadata {

  private String createAt;
  private String processedAt;
  private Float totalTimeTaken;


}
