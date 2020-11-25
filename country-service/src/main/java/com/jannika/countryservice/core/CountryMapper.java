package com.jannika.countryservice.core;

import com.jannika.countryservice.model.Countries;
import com.jannika.countryservice.model.Country;
import com.jannika.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {
    @Autowired
    private CountryService countryService;

    public List<Country> fetchCountries(){
        List<Countries> data = countryService.findAllCountries();
        return data
                .stream()
                .map(this::response)
                .collect(Collectors.toList());
    }

    public Country fetchCountryByName(String name) {
        List<Countries> data = countryService.findCountryByName(name);
        return response(data.get(0));
    }

    private Country response(Countries countries){
        Country country = null;
        if(countries != null){
            country = new Country();
            country.setName(countries.getName());
            country.setAlpha2Code(countries.getAlpha2Code());
            country.setCapital(countries.getCapital());
            country.setPopulation(countries.getPopulation());
            country.setFlag(countries.getFlag());
        }
        return country;
    }

}
