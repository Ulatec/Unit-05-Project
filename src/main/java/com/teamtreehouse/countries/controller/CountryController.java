package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @RequestMapping("/")
    public String listCountries(@RequestParam(name = "sortType", defaultValue = "", required = false) String sortType, ModelMap modelMap){
        List<Country> countries;
        switch (sortType) {
            case "name":
                countries = countryRepository.getAllCountriesByName();
                break;
            case "population":
                countries = countryRepository.getAllCountriesByPopulation();
                break;
            default:
                countries = countryRepository.getAllCountries();
                break;
        }
        modelMap.put("countries", countries);
        return "index";
    }
    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap){
        Country country = countryRepository.findCountryByName(name);
        modelMap.put("country", country);
        return "country";
    }
}
