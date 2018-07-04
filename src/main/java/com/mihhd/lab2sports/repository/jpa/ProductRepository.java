package com.mihhd.lab2sports.repository.jpa;

import com.mihhd.lab2sports.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"category", "manufacturer"})
    List<Product> findAll();


    List<Product> findByManufacturerNameLike(String manufacturer);
}
