package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * Checks if the city exists in a list.
     * @param city
     * @return
     * Returns true if city exists, false if it doesn't
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }
    /**
     * This deletes a city to the list if the city exist
     * @param city
     * This is a candidate city to add
     */
    public void delete(City city){
        if (!hasCity(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
    /**
     * Counts the number of cities in the list.
     * @return
     * Return the number of cities in the list
     */
    public int countCities(){
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}
