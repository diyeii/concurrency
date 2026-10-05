package org.ies.tierno.salas;

import java.util.concurrent.Executors;

public class Sala {

    public void entrar(String nombre) throws InterruptedException {
        System.out.println(nombre + " ENTRA");
        Thread.sleep(1000);              // simula trabajo dentro de la sección crítica
        System.out.println(nombre + " SALE");
    }


    public static void main(String[] args) {
        Sala sala = new Sala();

        long initTime = System.nanoTime();
        try (var es = Executors.newFixedThreadPool(4)) {
            es.submit(
                    () -> {
                        try {
                            new Sala().entrar("Hilo 1");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );

            es.submit(() -> {
                try {
                    sala.entrar("Hilo 2");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            es.submit(() -> {
                try {
                    sala.entrar("Hilo 3");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            es.submit(() -> {
                try {
                    sala.entrar("Hilo 4");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        long endTime = System.nanoTime();
        System.out.println("Ha tardado " + (endTime - initTime));
    }
}