package com.tren.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tren.demo.Entity.Estacion;
import com.tren.demo.Entity.TrenSimulador;
import com.tren.demo.service.EstacionService;

@RestController
@RequestMapping("/api/tren")
public class TrenRestController {

    @Autowired
    private EstacionService estacionService;

    @Autowired
    private TrenSimulador trenSimulador;

    @GetMapping("/estado")
    public Map<String, String> getEstadoTren() {
        int pos = trenSimulador.getPosicionActual();
        Estacion estacion = estacionService.buscarPorOrden(pos);
        String nombre = estacion != null ? estacion.getNombre_estacion() : "Desconocido";
        String direccion = trenSimulador.getDireccion();

        Map<String, String> data = new HashMap<>();
        data.put("estacion", nombre);
        data.put("direccion", direccion);
        return data;
    }
}
