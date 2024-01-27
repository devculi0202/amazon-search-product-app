package com.devculi.application.amazon.controller;

import com.devculi.application.amazon.domain.autocomplete.Suggestions;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import com.devculi.application.amazon.invokers.AutoCompleteApiInvoker;
import com.devculi.application.amazon.services.SearchAutoCompleteService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeachAutoCompleteController {

  @Autowired
  private AutoCompleteApiInvoker rainForestApiInvoker;

  @Autowired
  private SearchAutoCompleteService searchAutoCompleteService;

  @GetMapping("/search/autocomplete")
  public List<Suggestions> searchAutoComplete(
      @RequestParam(name = "term", required = false) String term,
      Model model) throws ThirdPartyException {
    return searchAutoCompleteService.searchAutoCompleteBySearchTerm(term).orElse(
        Collections.EMPTY_LIST);
  }
}
