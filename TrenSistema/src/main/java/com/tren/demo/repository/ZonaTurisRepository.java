package com.tren.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tren.demo.Entity.ZonaTuristica;

@Repository("zonaTurisRepository")
public interface ZonaTurisRepository extends JpaRepository<ZonaTuristica, Integer> {

    @Query(value = "SELECT * FROM zona_turistica WHERE id_estacion = ?1", nativeQuery = true)
    List<ZonaTuristica> findByEstacionId(int estacionId);

}
