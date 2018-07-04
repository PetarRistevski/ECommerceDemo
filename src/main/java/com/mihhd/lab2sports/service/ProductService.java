package com.mihhd.lab2sports.service;

import com.mihhd.lab2sports.model.Product;

import java.util.List;

public interface ProductService extends BaseEntityService<Product> {
    public Product findOne(Long id);
    List<Product> findByCategoryId(Long id);
    List<Product> findByManufacturerNameLike(String name);
}
