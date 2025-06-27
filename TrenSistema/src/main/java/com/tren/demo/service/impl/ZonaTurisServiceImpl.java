package com.tren.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tren.demo.Entity.ZonaTuristica;
import com.tren.demo.repository.ZonaTurisRepository;
import com.tren.demo.service.ZonaTurisService;

@Service("zonaTurisService")
public class ZonaTurisServiceImpl implements ZonaTurisService {

    @Autowired
    @Qualifier("zonaTurisRepository")
    private ZonaTurisRepository zonaRepo;

    @Override
    public List<ZonaTuristica> buscarPorEstacion(int estacionId) {
        return zonaRepo.findByEstacionId(estacionId);
    }

}
