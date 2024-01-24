package com.devculi.application.amazon.services;

import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import com.devculi.application.amazon.domain.autocomplete.AutoCompleteResults;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import com.devculi.application.amazon.invokers.RainForestApiInvoker;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchAutoCompleteServiceImpl implements SearchAutoCompleteService {
  private RainForestApiInvoker rainForestApiInvoker;

  @Autowired
  public SearchAutoCompleteServiceImpl(RainForestApiInvoker rainForestApiInvoker){
    this.rainForestApiInvoker = rainForestApiInvoker;
  }

  @Override
  public Optional<List<AutoCompleteResults>> searchAutoCompleteBySearchTerm(String searchTerm)
      throws  ThirdPartyException {
    ResponseEntity<AmazonAutoComplete> results =  rainForestApiInvoker.invokeGetAutoCompleteAmazon(searchTerm);
    if (results!= null && results.getBody() != null){
      return Optional.of(results.getBody().getAutoCompleteResults());
    }
    return Optional.empty();

  }
}
