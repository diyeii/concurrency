package org.ies.tierno.tortugas;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TortugaMain {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        var es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.submit(new Tortuga("Tortuga-" + i, random));
        }

        // Esta llamada no es bloqueante
        es.shutdown();
        // Esta llamada es bloqueante, espera a que todas tareas hayan finalizado
        es.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Carrera terminada");
    }
}
