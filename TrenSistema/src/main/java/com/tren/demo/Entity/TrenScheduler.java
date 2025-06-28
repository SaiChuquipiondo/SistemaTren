package com.tren.demo.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TrenScheduler {

    @Autowired
    private TrenSimulador tren;

    @PostConstruct
    public void iniciarSimulacion() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    int nuevaPosicion = tren.avanzar();
                    // System.out.println("Tren llegó a estación " + nuevaPosicion);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
