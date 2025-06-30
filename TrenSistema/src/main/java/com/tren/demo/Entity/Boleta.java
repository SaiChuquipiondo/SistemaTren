package com.tren.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bolid")
    private int id;

    @Column(name = "Bolnombrecliente", length = 50)
    private String nombrec;

    @Column(name = "Bolnumerotelefono", length = 100)
    private String telefonoc;

    @Column(name = "Bolcantidadpasajeros")
    private int cantidadpasajeros;

    @Column(name = "Bolfecha", length = 100)
    private java.sql.Date fecha;

    @Column(name = "Bolmonto", length = 100)
    private float monto;

    @ManyToOne
    @JoinColumn(name = "Estidinicio")
    private Estacion estacioninicio;

    @ManyToOne
    @JoinColumn(name = "Estiddestino")
    private Estacion estaciondestino;

    @ManyToOne
    @JoinColumn(name = "Zntid")
    private ZonaTuristica zonaturistica;



}
