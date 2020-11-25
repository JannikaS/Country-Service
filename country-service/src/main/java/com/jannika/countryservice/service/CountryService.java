package com.jannika.countryservice.service;

import com.jannika.countryservice.model.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryServiceProxy countryServiceProxy;

    public List<Countries> findAllCountries() {

        return countryServiceProxy.retrieveAllCountries();
    }

    public List<Countries> findCountryByName(String countryName) {
        return countryServiceProxy.retrieveCountryByName(countryName);
    }
}

