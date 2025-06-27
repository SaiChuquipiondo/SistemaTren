package com.tren.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ZonaTuristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private int id;

    @Column(name = "nombre_zona", length = 50)
    private String nombre;

    @Column(name = "direccion_zona", length = 100)
    private String direccion;

    @Column(name = "duracion_caminata_zona")
    private int duracionCaminata;

    @Column(name = "servicios_zona", length = 100)
    private String servicios;

    @ManyToOne
    @JoinColumn(name = "id_estacion")
    private Estacion estacion;
}