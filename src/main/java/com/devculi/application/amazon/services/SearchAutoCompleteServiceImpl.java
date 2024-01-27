package com.devculi.application.amazon.services;

import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import com.devculi.application.amazon.domain.autocomplete.Suggestions;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import com.devculi.application.amazon.invokers.AutoCompleteApiInvoker;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchAutoCompleteServiceImpl implements SearchAutoCompleteService {
  private AutoCompleteApiInvoker rainForestApiInvoker;

  @Autowired
  public SearchAutoCompleteServiceImpl(AutoCompleteApiInvoker rainForestApiInvoker){
    this.rainForestApiInvoker = rainForestApiInvoker;
  }

  @Override
  public Optional<List<Suggestions>> searchAutoCompleteBySearchTerm(String searchTerm)
      throws  ThirdPartyException {
    System.out.println("Start invoking search autocomplete");
    ResponseEntity<AmazonAutoComplete> results =  rainForestApiInvoker.invokeGetAutoCompleteAmazon(searchTerm);
    if (results!= null && results.getBody() != null){
      System.out.println("Stopped invoking search autocomplete");
      return Optional.of(results.getBody().getSuggestions());
    }
    System.out.println("Stopped invoking search autocomplete");
    return Optional.empty();

  }
}
