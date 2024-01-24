package com.devculi.application.amazon.services;

import com.devculi.application.amazon.domain.autocomplete.AutoCompleteResults;
import com.devculi.application.amazon.exceptions.ThirdPartyException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public interface SearchAutoCompleteService {
   Optional<List<AutoCompleteResults>> searchAutoCompleteBySearchTerm(String searchTerm)
       throws ThirdPartyException;
}
