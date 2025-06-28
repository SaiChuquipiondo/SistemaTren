package com.tren.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tren.demo.Entity.Estacion;
import com.tren.demo.Entity.TrenSimulador;
import com.tren.demo.service.EstacionService;
import com.tren.demo.service.ZonaTurisService;

@Controller
public class HomeController {

    @Autowired
    private EstacionService estacionService;
    @Autowired
    private ZonaTurisService zonaTuristicaService;
    @Autowired
    private TrenSimulador trenSimulador;

    @GetMapping("/")
    public String vistaGeneral(Model model) {
        List<Estacion> estaciones = estacionService.listarTodas();
        int posTren = trenSimulador.getPosicionActual();
        Estacion estacionActualTren = estacionService.buscarPorOrden(posTren);

        model.addAttribute("estaciones", estaciones);
        model.addAttribute("posicionTren", estacionActualTren);
        return "home";
    }

}
