package com.tren.demo.Entity;

import java.util.Map;

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

    @PostConstruct
    public void iniciarSimulacionClima() {
    new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(10000); // cada 10 segundos
                tren.generarClimaParaEstacionesMap(); // <-- ESTA ES LA BUENA

                System.out.println("======= CLIMA ACTUALIZADO =======");
                tren.getClimaActualPorEstacion().forEach((idEstacion, clima) -> {
                    System.out.println("Estación " + idEstacion + ": " + clima);
                });
                System.out.println("=================================");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}

}
