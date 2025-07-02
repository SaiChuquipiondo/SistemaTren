package com.tren.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tren.demo.Entity.Estacion;

@Repository("estacionRepository")
public interface EstacionRepository extends JpaRepository<Estacion, Integer> {

    default Optional<Estacion> findById(Long id) {
        return findById(Integer.valueOf(id.intValue()));
    }


}
