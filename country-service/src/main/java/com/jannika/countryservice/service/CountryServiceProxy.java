package com.jannika.countryservice.service;


import com.jannika.countryservice.model.Countries;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CountryServiceProxy {

    @GetMapping(value = "rest/v2/all")
    List<Countries> retrieveAllCountries();

    @GetMapping(value = "rest/v2/name/{countryName}?fullText=true")
    List<Countries> retrieveCountryByName(@PathVariable("countryName") String countryName);
}
