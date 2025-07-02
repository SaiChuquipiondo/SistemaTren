package com.tren.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tren.demo.Entity.Clima;
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
        Estacion estacion1 = estacionService.buscarPorOrden(pos);
        String nombre1 = estacion1 != null ? estacion1.getNombre_estacion() : "Desconocido";
        String direccion = trenSimulador.getDireccion();    
        Estacion estacion2= direccion.equals("IDA")? estacionService.buscarPorOrden(pos+1) : estacionService.buscarPorOrden(pos-1);
        String nombre2 = estacion2 != null ? estacion2.getNombre_estacion() : "Desconocido";

        Map<String, String> data = new HashMap<>();
        data.put("estacion1", nombre1);
        data.put("estacion2", nombre2);
        data.put("numero", String.valueOf(pos));
        data.put("direccion", direccion);
        return data;
    }

    @GetMapping("/clima")
    public Map<Integer, Object> getClimaActual() {
    Map<Integer, Clima> climaPorEstacion = trenSimulador.getClimaActualPorEstacion();
    Map<Integer, Object> respuesta = new HashMap<>();

    for (Map.Entry<Integer, Clima> entry : climaPorEstacion.entrySet()) {
        Map<String, Object> infoClima = new HashMap<>();
        infoClima.put("temperatura", entry.getValue().getTemperatura());
        infoClima.put("descripcion", entry.getValue().getDescripcion());
        respuesta.put(entry.getKey(), infoClima);
    }

    return respuesta;
}

}
