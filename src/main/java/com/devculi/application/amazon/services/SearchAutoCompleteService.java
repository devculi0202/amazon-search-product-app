package com.devculi.application.amazon.services;

import com.devculi.application.amazon.domain.autocomplete.Suggestions;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import java.util.List;
import java.util.Optional;


public interface SearchAutoCompleteService {
   Optional<List<Suggestions>> searchAutoCompleteBySearchTerm(String category, String searchTerm)
       throws ThirdPartyException;
}
