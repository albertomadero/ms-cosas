package com.alberto.api_cosas.repository;

import com.alberto.api_cosas.model.Cosa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosaRepository extends JpaRepository<Cosa, Long> {
    List<Cosa> findByPropietario(String propietario);
}
