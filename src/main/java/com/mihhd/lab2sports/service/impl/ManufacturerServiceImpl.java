package com.mihhd.lab2sports.service.impl;

import com.mihhd.lab2sports.service.ManufacturerService;
import com.mihhd.lab2sports.repository.jpa.ManufacturerRepository;
import com.mihhd.lab2sports.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Optional<Manufacturer> findById(Long id){
        return null;
    }

    @Override
    public Collection<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer save(Manufacturer entity) {
        return manufacturerRepository.save(entity);
    }
}
