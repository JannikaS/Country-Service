package com.jannika.countryservice.controller;


import com.jannika.countryservice.core.CountryMapper;
import com.jannika.countryservice.model.Country;
import com.jannika.countryservice.model.CountryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.ok;
import java.util.List;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {
    @Autowired
    private CountryMapper countryMapper;

    @GetMapping
    public ResponseEntity<CountryData> getCountries (){
        List<Country> countryList = countryMapper.fetchCountries();
        CountryData countries = new CountryData();
        countries.setCountries(countryList);
        return ok(countries);
    }


    @GetMapping(value = "{name}")
    public ResponseEntity<Country> getCountryByName(@PathVariable("name") String name) {
        Country country = countryMapper.fetchCountryByName(name);
        return ok(country);
    }
}
