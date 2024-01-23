package com.devculi.application.amazon.invokers;

import com.devculi.application.amazon.constants.APIConstant;
import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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

  public ResponseEntity<AmazonAutoComplete> invokeGetAutoCompleteAmazon(String path,
      String searchTerm) {
    ResponseEntity<AmazonAutoComplete> completeAmazonResults = null;
    try {
      String url = buildUrl(path, searchTerm);
      completeAmazonResults = restTemplate.getForEntity(url, AmazonAutoComplete.class);
    } catch (HttpStatusCodeException e) {
      System.out.println(completeAmazonResults);
    }
    return completeAmazonResults;
}

private String buildUrl(String path, String searchTerm) {
  UriComponents uriComponents = UriComponentsBuilder.newInstance()
      .scheme(APIConstant.SCHEMA).host(APIConstant.HOST).path(path)
      .queryParam("api_key", APIConstant.API_KEY)
      .queryParam("type", "autocomplete")
      .queryParam("amazon_domain", "amazon.com")
      .queryParam("search_term", searchTerm).build();
  return uriComponents.toUriString();
}

}
