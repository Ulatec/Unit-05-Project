package com.teamtreehouse.countries.model;

import java.util.List;

/**
 * Created by mark on 4/12/2017.
 */
public class Country {
    private String name;
    private List<String> languages;
    private int population;
    private String capitalCity;

    public Country(String name, List<String> languages, int population, String capitalCity) {
        this.name = name;
        this.languages = languages;
        this.population = population;
        this.capitalCity = capitalCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
}
