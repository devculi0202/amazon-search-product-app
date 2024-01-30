package com.devculi.application.amazon.invokers;

import com.devculi.application.amazon.constants.APIConstant;
import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AutoCompleteApiInvoker {

  @Autowired
  private RestTemplate restTemplate;

  public ResponseEntity<AmazonAutoComplete> invokeGetAutoCompleteAmazon(String category, String searchTerm)
      throws ThirdPartyException {
    ResponseEntity<AmazonAutoComplete> completeAmazonResults = null;
    try {
      String url = buildUrl(category, searchTerm);
      completeAmazonResults = restTemplate.getForEntity(url, AmazonAutoComplete.class);
    } catch (HttpStatusCodeException e) {
      System.out.println(String.format("Error %s", e.getMessage()));
      throw new ThirdPartyException(e.getMessage());
    }
    return completeAmazonResults;
  }

  private String buildUrl(String category, String searchTerm) {
    UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme(APIConstant.SCHEMA)
        .host(APIConstant.HOST).path(APIConstant.AUTOCOMPLETE_PATH)
        .queryParam("mid", APIConstant.API_KEY).queryParam("alias", category)
        .queryParam("prefix", searchTerm).build();
    return uriComponents.toUriString();
  }

}
