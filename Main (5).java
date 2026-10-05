package org.ies.tierno.ej1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int VUELTAS = 100_000;

    public static void main(String[] args) {



        Contador contador = new Contador();

        Runnable incrementarMuchasVeces = () -> {
            for (int i = 0; i < VUELTAS; i++) {
                contador.incrementar();
            }
        };

        long startTime = System.nanoTime();

        try (ExecutorService pool = Executors.newFixedThreadPool(2)) {
            pool.submit(incrementarMuchasVeces);
            pool.submit(incrementarMuchasVeces);
        }

        long endTime = System.nanoTime();

        System.out.println("Resultado: " + contador.getValor());
        System.out.println("Ha tardado: " + (endTime - startTime));
    }
}