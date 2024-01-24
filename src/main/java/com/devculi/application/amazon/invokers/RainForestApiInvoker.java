package com.devculi.application.amazon.invokers;

import com.devculi.application.amazon.constants.APIConstant;
import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RainForestApiInvoker {

  @Autowired
  private RestTemplate restTemplate;

  public ResponseEntity<AmazonAutoComplete> invokeGetAutoCompleteAmazon(String searchTerm)
      throws ThirdPartyException {
    ResponseEntity<AmazonAutoComplete> completeAmazonResults = null;
    try {
      String url = buildUrl(searchTerm);
      completeAmazonResults = restTemplate.getForEntity(url, AmazonAutoComplete.class);
    } catch (HttpStatusCodeException e) {
      System.out.println(String.format("Error %s", e.getMessage()));
      throw new ThirdPartyException(e.getMessage());
    }
    return completeAmazonResults;
  }

  private String buildUrl(String searchTerm) {
    UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(APIConstant.SCHEMA)
        .host(APIConstant.HOST).path(APIConstant.AUTOCOMPLETE_PATH)
        .queryParam("api_key", APIConstant.API_KEY).queryParam("type", "autocomplete")
        .queryParam("amazon_domain", "amazon.com").queryParam("search_term", searchTerm).build();
    return uriComponents.toUriString();
  }

}
