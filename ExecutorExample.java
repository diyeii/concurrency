package org.ies.tierno.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        // Crea un pool de hilos con 3 hilos
        ExecutorService pool = Executors.newFixedThreadPool(9);
        // Define la duración de cada tarea
        int[] duration = {3, 2, 4, 2, 1, 3, 2, 4, 2};

        // Creamos 9 tareas que se van a ejecutar sobre esos 3 hilos, de manera que habrá un máximo
        // de 3 tareas ejecutándose concurrentemente
        for (int i = 0; i < 9; i++) {
            int n = i + 1;
            int taskDuration = duration[i];
            // Equivala thread.start()
            pool.submit(() -> {
                try {
                    Thread.sleep(taskDuration * 500L);
                    System.out.println("Tarea " + n + " finalizada");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        // Ordenamos destruir el pool y sus threads
        pool.shutdown();
        // Esperamos a que acaben las tareas que se estén ejecutando, como máximo espera 1 minuto
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
