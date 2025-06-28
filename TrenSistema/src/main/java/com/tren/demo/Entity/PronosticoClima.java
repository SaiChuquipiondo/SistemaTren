package com.tren.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PronosticoClima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pronostico")
    private int id_pronostico;

    @Column(name = "cond_pronostico", length = 30)
    private String condicion;

    @Column(name = "temp_pronostico")
    private double temperatura;

}
