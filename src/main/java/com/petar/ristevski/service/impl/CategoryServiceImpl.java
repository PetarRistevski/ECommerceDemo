package com.petar.ristevski.service.impl;

import com.petar.ristevski.repository.jpa.CategoryRepository;
import com.petar.ristevski.model.Category;
import com.petar.ristevski.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Collection<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }
}
