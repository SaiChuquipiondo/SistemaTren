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
    @Column(name = "Zntid")
    private int id;

    @Column(name = "Zntnombre", length = 50)
    private String nombre;

    @Column(name = "Zntdireccion", length = 100)
    private String direccion;

    @Column(name = "Zntdescripcion")
    private int duracionCaminata;

    @Column(name = "Znttiempocaminata", length = 100)
    private String servicios;

    @ManyToOne
    @JoinColumn(name = "Estid")
    private Estacion estacion;


}