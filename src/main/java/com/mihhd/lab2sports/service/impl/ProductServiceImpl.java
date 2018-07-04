package com.mihhd.lab2sports.service.impl;

import com.mihhd.lab2sports.model.Product;
import com.mihhd.lab2sports.repository.jpa.ProductRepository;
import com.mihhd.lab2sports.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(repo.getOne(id));
    }

    public Product findOne(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Collection<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product save(Product entity) {
        return repo.save(entity);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return repo.findByCategoryId(id);
    }

    @Override
    public List<Product> findByManufacturerNameLike(String name) {
        return repo.findByManufacturerNameLike(name);
    }
}
