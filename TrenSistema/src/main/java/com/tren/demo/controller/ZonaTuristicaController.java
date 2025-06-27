package com.tren.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tren.demo.service.ZonaTurisService;

@Controller
@RequestMapping("/zonas")
public class ZonaTuristicaController {
    @Autowired
    @Qualifier("zonaTurisService")
    private ZonaTurisService zonaService;

    @GetMapping("/{idEstacion}")
    public String mostrarZonas(@PathVariable int idEstacion, Model model) {
        model.addAttribute("zonas", zonaService.buscarPorEstacion(idEstacion));
        return "zonas";
    }
}
