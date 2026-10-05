package org.ies.tierno.tortugas;

import java.util.Random;

public class Tortuga implements Runnable {
    private final String nombre;
    private final Random random;

    public Tortuga(String nombre, Random random) {
        this.nombre = nombre;
        this.random = random;
    }

    @Override
    public void run() {
        int pasos = 0;

        for (int i = 0; i < 20; i++) {
            System.out.println(nombre + ", paso " + (i + 1));
            try {
                Thread.sleep(random.nextLong(50, 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println( nombre +" ha llegado a la meta!");
    }
}
