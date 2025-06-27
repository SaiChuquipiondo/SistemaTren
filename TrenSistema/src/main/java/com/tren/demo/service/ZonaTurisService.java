package com.tren.demo.service;

import java.util.List;

import com.tren.demo.Entity.ZonaTuristica;

public interface ZonaTurisService {

    public abstract List<ZonaTuristica> buscarPorEstacion(int estacionId);
}
