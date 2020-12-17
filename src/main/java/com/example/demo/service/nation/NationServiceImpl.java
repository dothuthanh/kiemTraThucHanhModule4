package com.example.demo.service.nation;

import com.example.demo.model.Nation;
import com.example.demo.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public void save(Nation city) {
        nationRepository.save(city);

    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);

    }
}