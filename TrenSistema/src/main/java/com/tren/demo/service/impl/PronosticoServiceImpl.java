package com.tren.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tren.demo.Entity.PronosticoClima;
import com.tren.demo.repository.PronosticoRepository;
import com.tren.demo.service.PronosticoSerivce;

@Service("pronosticoService")
public class PronosticoServiceImpl implements PronosticoSerivce {

    @Autowired
    @Qualifier("pronosticoRepository")
    private PronosticoRepository pronosticoRepository;

    @Override
    public PronosticoClima obtenerClima(int id_clima) {
        return pronosticoRepository.findById(id_clima).orElse(null);
    }

}
