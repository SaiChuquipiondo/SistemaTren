package com.tren.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tren.demo.service.PronosticoSerivce;

@Controller
@RequestMapping("/clima")
public class PronosticoController {
    @Autowired
    @Qualifier("pronosticoService")
    private PronosticoSerivce climaService;

    @GetMapping("/{idEstacion}")
    public String mostrarClima(@PathVariable int idclima, Model model) {
        model.addAttribute("pronosticos", climaService.obtenerClima(idclima));
        return "clima";
    }
}
