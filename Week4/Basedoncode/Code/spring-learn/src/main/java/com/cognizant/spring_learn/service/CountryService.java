package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    // Replace or add countries here
    private List<Country> countryList = Arrays.asList(
        new Country("US", "United States"),
        new Country("UK", "United Kingdom"),
        new Country("CA", "Canada"),
        new Country("AUS", "Australia")
    );

    public Country getCountry(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); // Optional: replace with custom exception
    }
}
