package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by mark on 4/12/2017.
 */
@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Ecuador", Arrays.asList("Spanish"), 16144000, "Quito" ),
            new Country("France",Arrays.asList("French"), 66991000 , "Paris"),
            new Country("India",Arrays.asList("Hindi", "English"), 1310069000, "New Delhi"),
            new Country("Italy", Arrays.asList("Italian"), 60674003, "Rome"),
            new Country("Kenya", Arrays.asList("Kiswahili", "English"), 46661552, "Nairobi")
    );

    public Country findCountryByName(String countryName){
        return (ALL_COUNTRIES.stream()
                .filter(country -> country.getName().equals(countryName))
                .findFirst()
                .orElse(null)
        );
    }

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public List<Country> getAllCountriesByPopulation() {
       return(ALL_COUNTRIES.stream().sorted((e1,e2) -> Integer.compare(e2.getPopulation(), e1.getPopulation())).collect(Collectors.toList()));
    }
    public List<Country> getAllCountriesByName(){
        return(ALL_COUNTRIES.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList()));
    }
}
