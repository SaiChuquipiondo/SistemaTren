package com.tren.demo.service;

import java.util.List;

import com.tren.demo.Entity.Estacion;

public interface EstacionService {

    public abstract List<Estacion> listarTodas();

    public abstract Estacion buscarEstacion(int id_estacion);

    public abstract Estacion buscarPorOrden(int numero_orden_estacion);

    public int calcularTiempoLlegada(int posicionTren, int estacionObjetivo, boolean haciaAdelante);

    public int calcularTiempoViaje(int estacionOrigen, int estacionDestino, boolean direccionInicialTren,
            int posicionTren);

}
