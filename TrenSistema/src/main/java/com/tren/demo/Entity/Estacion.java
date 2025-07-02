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

public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Estid")
    private int id_estacion;
    @Column(name = "Estnombre", length = 30)
    private String nombre_estacion;

    @Column(name = "Estnumero")
    private int ordenEstacion;

    @Column(name = "Estlatitud", nullable = false)
    private double latitud;

    @Column(name = "Estlongitud", nullable = false)
    private double longitud;

    @OneToMany(mappedBy = "estacion")
    private List<ZonaTuristica> zonas;

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public String getNombre_estacion() {
        return nombre_estacion;
    }
    
    public void setNombre_estacion(String nombre_estacion) {
        this.nombre_estacion = nombre_estacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getOrdenEstacion() {
        return ordenEstacion;
    }

    public void setOrdenEstacion(int ordenEstacion) {
        this.ordenEstacion = ordenEstacion;
    }

    public List<ZonaTuristica> getZonas() {
        return zonas;
    }

    public void setZonas(List<ZonaTuristica> zonas) {
        this.zonas = zonas;
    }










}
