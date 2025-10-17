package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    //Lab Exercise tests. Has city test
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        City newCity = new City("Edmonton", "Alberta");
        assertFalse(cityList.hasCity(newCity));
    }
    //Lab Exercise test. delete city test
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        //add city to list, make sure it's added, remove it and make sure it's removed
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }
    //test if exception is thrown if city does not exist
    @Test
    void testDeleteException(){
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    @Test
    void testCityCount(){
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        City newcity = new City("Edmonton", "Alberta");
        cityList.add(newcity);
        assertEquals(2, cityList.countCities());
        cityList.delete(newcity);
        assertEquals(1, cityList.countCities());
    }

}
