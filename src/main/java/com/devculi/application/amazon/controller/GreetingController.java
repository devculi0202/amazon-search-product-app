package com.devculi.application.amazon.controller;

import com.devculi.application.amazon.domain.autocomplete.AmazonAutoComplete;
import com.devculi.application.amazon.invokers.RainForestApiInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

  @Autowired
  private RainForestApiInvoker rainForestApiInvoker;

  @GetMapping("/greeting")
  public String greeting(
      @RequestParam(name = "name", required = false) String name,
      Model model) {
    ResponseEntity<AmazonAutoComplete> results =  rainForestApiInvoker.invokeGetAutoCompleteAmazon("/request", "clothes");
    if (results != null)  {
      System.out.println(results.getBody().toString());
    }
    model.addAttribute("name", results.getBody().getAutoCompleteResults());
    return "greeting";
  }
}
