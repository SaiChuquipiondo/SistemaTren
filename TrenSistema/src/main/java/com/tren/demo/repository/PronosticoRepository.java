package com.tren.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tren.demo.Entity.PronosticoClima;

@Repository("pronosticoRepository")
public interface PronosticoRepository extends JpaRepository<PronosticoClima, Integer> {

}
