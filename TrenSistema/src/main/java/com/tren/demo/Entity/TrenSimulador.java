package com.tren.demo.Entity;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TrenSimulador {
    private int posicionActual = new Random().nextInt(14) + 1;
    private boolean haciaAdelante = true;

    public synchronized int avanzar() {
        if (haciaAdelante) {
            posicionActual++;
            if (posicionActual >= 14)
                haciaAdelante = false;
        } else {
            posicionActual--;
            if (posicionActual <= 1)
                haciaAdelante = true;
        }
        return posicionActual;
    }

    public synchronized int getPosicionActual() {
        return posicionActual;
    }

    public synchronized void setPosicionActual(int posicion) {
        this.posicionActual = posicion;
    }
}
