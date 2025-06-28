package com.tren.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tren.demo.Entity.Estacion;
import com.tren.demo.Entity.TrenSimulador;
import com.tren.demo.service.EstacionService;

@Controller
@RequestMapping("/viaje")
public class ViajeController {
    @Autowired
    @Qualifier("estacionService")
    private EstacionService estacionService;

    @Autowired
    private TrenSimulador trenSimulador;

    @GetMapping("/calcular-tiempo-real")
    public String calcularTiempoReal(@RequestParam int estacionOrigen,
            @RequestParam int estacionDestino,
            Model model) {

        int posicionTren = trenSimulador.getPosicionActual();

        int tiempoLlegada = estacionService.calcularTiempo(posicionTren, estacionOrigen);
        int tiempoViaje = estacionService.calcularTiempo(estacionOrigen, estacionDestino);

        Estacion estacionActualTren = estacionService.buscarPorOrden(posicionTren);
        Estacion origen = estacionService.buscarPorOrden(estacionOrigen);
        Estacion destino = estacionService.buscarPorOrden(estacionDestino);

        model.addAttribute("posicionTren", estacionActualTren);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        model.addAttribute("tiempoLlegada", tiempoLlegada);
        model.addAttribute("tiempoViaje", tiempoViaje);

        return "tiempo-real";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estaciones", estacionService.listarTodas());
        return "formulario-viaje";
    }
}
