package com.devculi.application.amazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
  @GetMapping("/search/products")
  public String getProductsPage(){
    return "product-listing";
  }



}
