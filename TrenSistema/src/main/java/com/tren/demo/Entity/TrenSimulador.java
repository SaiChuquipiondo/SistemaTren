package com.tren.demo.Entity;

import java.util.Random;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random; 
import com.tren.demo.Entity.Clima;

@Component
public class TrenSimulador {
    private int posicionActual = new Random().nextInt(14);
    private boolean haciaAdelante = true;
    private final Random random = new Random();
    private Map<Integer, Clima> climaActualPorEstacion = new HashMap<>();
    
    private final String[] estadosClima = {
        "Soleado", "Nublado", "Lluvia", "Tormenta", "Viento", "Nevado"
    };
    

    public Map<Integer, Clima> generarClimaParaEstacionesMap() {
    climaActualPorEstacion.clear();

    for (int i = 1; i <= 14; i++) {
        int temperatura = random.nextInt(36); // 0 a 35 grados
        String estado;

        // Lista de climas posibles según temperatura
        List<String> climasPosibles = new ArrayList<>();

        if (temperatura <= 5) {
            climasPosibles = List.of("Nevado", "Nublado");
        } else if (temperatura <= 15) {
            climasPosibles = List.of("Lluvia", "Nublado", "Viento");
        } else if (temperatura <= 25) {
            climasPosibles = List.of("Nublado", "Viento", "Soleado", "Lluvia");
        } else {
            climasPosibles = List.of("Soleado", "Viento", "Tormenta");
        }

        estado = climasPosibles.get(random.nextInt(climasPosibles.size()));
        climaActualPorEstacion.put(i, new Clima(temperatura, estado));
    }

    return climaActualPorEstacion;
}


    public Map<Integer, Clima> getClimaActualPorEstacion() {
            return climaActualPorEstacion;
    }




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

    // Simula climas para cada estación (ID 1 al 14)
    public Map<Integer, Clima> generarClimaParaEstaciones() {
        Map<Integer, Clima> mapaClimas = new HashMap<>();

        for (int i = 1; i <= 14; i++) {
            int temperatura = random.nextInt(36); // 0°C a 35°C
            String estado = estadosClima[random.nextInt(estadosClima.length)];

            Clima clima = new Clima(temperatura, estado);
            mapaClimas.put(i, clima);
        }

        return mapaClimas;
    }

    



    public synchronized String getDireccion() {
        return haciaAdelante ? "IDA" : "VUELTA";
    }

    public synchronized int getPosicionActual() {
        return posicionActual;
    }

    public synchronized void setPosicionActual(int posicion) {
        this.posicionActual = posicion;
    }
}
