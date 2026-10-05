package org.ies.tierno.contador;

import java.util.Random;

public class Contador implements Runnable {
    private final String nombre;
    private final int numVueltas;

    public Contador(String nombre, int numVueltas) {
        this.nombre = nombre;
        this.numVueltas = numVueltas;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < numVueltas; i++) {
            System.out.println("Soy " + nombre + ", vuelta " + (i + 1));
            try {
                Thread.sleep(random.nextLong(10, 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
