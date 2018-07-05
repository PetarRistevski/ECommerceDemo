package com.petar.ristevski.repository.jpa;

import com.petar.ristevski.model.Category;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Profile("jpa")
public interface CategoryRepository extends JpaRepository<Category, Long>{
    List<Category> findByName (String name);

}
