package com.tren.demo.controller;

import com.tren.demo.Entity.ZonaTuristica;
import com.tren.demo.service.ZonaTurisService;
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

    @Autowired
    private ZonaTurisService zonaTurisService;

    @GetMapping("/calcular-tiempo-real")
    public String calcularTiempoReal(@RequestParam int estacionOrigen,
            @RequestParam int estacionDestino, @RequestParam int idZona,
            Model model) {

        int posicionTren = trenSimulador.getPosicionActual();
        boolean haciaAdelante = trenSimulador.getDireccion().equalsIgnoreCase("IDA");

        int tiempoLlegada = estacionService.calcularTiempoLlegada(posicionTren, estacionOrigen, haciaAdelante);
        int tiempoViaje = estacionService.calcularTiempoViaje(estacionOrigen, estacionDestino, haciaAdelante,
                posicionTren);

        System.out.println("Tiempo de llegada: " + tiempoLlegada + " segundos.");
        System.out.println("Tiempo de viaje: " + tiempoViaje + " segundos.");
        System.out.println(haciaAdelante ? "IDA" : "VUELTA");
        System.out.println("Posicion del tren: " + posicionTren);

        Estacion estacionActualTren = estacionService.buscarPorOrden(posicionTren);
        Estacion origen = estacionService.buscarPorOrden(estacionOrigen);
        Estacion destino = estacionService.buscarPorOrden(estacionDestino);

        ZonaTuristica zonaTuristica = zonaTurisService.buscarPoridZona(idZona);

        model.addAttribute("posicionTren", estacionActualTren);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        model.addAttribute("tiempoLlegada", tiempoLlegada);
        model.addAttribute("tiempoViaje", tiempoViaje);
        model.addAttribute("direccion", trenSimulador.getDireccion());
        model.addAttribute("posicionTrenOrden", posicionTren);
        model.addAttribute("origenOrden", estacionOrigen);
        model.addAttribute("destinoOrden", estacionDestino);
        model.addAttribute("zonaTuristica", zonaTuristica);

        return "tiempo-real";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estaciones", estacionService.listarTodas());
        return "formulario-viaje";
    }
}
