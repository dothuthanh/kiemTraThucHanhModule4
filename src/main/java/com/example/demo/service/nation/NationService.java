package com.example.demo.service.nation;

import com.example.demo.model.Nation;

public interface NationService {
    Iterable<Nation> findAll();
    void save(Nation city);
    Nation findById(Long id);
    void remove(Long id);
}
