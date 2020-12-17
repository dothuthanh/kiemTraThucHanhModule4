package com.example.demo.service.city;

import com.example.demo.model.City;

public interface CityService {
    Iterable<City> findAll();
    void save(City city);
    City findById(Long id);
    void remove(Long id);
}
