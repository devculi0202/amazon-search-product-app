package com.devculi.application.amazon.proxy;

import com.devculi.application.amazon.constants.APIConstant;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class RainForestApiInvoker {

  @Autowired
  private RestTemplate restTemplate;

  public void invokeAutoCompleteAmzon(HttpMethod httpMethod, Map<String, String> requestParams){

      restTemplate.getForEntity(APIConstant.API_ENDPOINT, String.class);
  }

}
