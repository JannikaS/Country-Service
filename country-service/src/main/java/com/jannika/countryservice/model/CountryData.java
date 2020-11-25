package com.jannika.countryservice.model;

import java.util.List;

public class CountryData {
    private List<Country> countries;
    public void setCountries(List<Country> countries){
        this.countries = countries;
    }

    public List<Country> getCountries(){
        return countries;
    }
}
