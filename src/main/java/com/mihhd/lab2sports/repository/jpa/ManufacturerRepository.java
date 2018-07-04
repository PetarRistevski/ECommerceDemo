package com.mihhd.lab2sports.repository.jpa;

import com.mihhd.lab2sports.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository <Manufacturer, Long> {
}
