package com.tren.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tren.demo.Entity.Estacion;
import com.tren.demo.repository.EstacionRepository;
import com.tren.demo.service.EstacionService;

@Service("estacionService")
public class EstacionServiceImpl implements EstacionService {

    @Autowired
    @Qualifier("estacionRepository")
    private EstacionRepository estacionRepository;

    @Override
    public List<Estacion> listarTodas() {
        return estacionRepository.findAll(Sort.by("ordenEstacion"));
    }

    @Override
    public Estacion buscarEstacion(int id_estacion) {
        return estacionRepository.findById(id_estacion).orElse(null);
    }

    @Override
    public Estacion buscarPorOrden(int numero_orden_estacion) {
        return estacionRepository.findAll().stream()
                .filter(e -> e.getOrdenEstacion() == numero_orden_estacion)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int calcularTiempo(int origen, int destino) {
        int estacionesEntre = Math.abs(origen - destino);
        return estacionesEntre * (10 + 5);
    }

}
