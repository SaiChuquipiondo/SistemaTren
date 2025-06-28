package com.tren.demo.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacion")
    private int id_estacion;
    @Column(name = "nombre_estacion", length = 30)
    private String nombre_estacion;

    @Column(name = "numero_orden_estacion")
    private int ordenEstacion;

    @OneToMany(mappedBy = "estacion")
    private List<ZonaTuristica> zonas;

}
