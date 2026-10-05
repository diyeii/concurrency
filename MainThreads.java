package org.ies.tierno.contador;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThreads {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Contador("Contador-" + i, 5));
            threads.add(t);
            t.start();
            // No puedo poner aquí el join porque hace que el programa se vuelva secuencial
        }

        // Este bucle recorre todos lo hilos haciendo join, al finalizalizar el bucle todos los hilos han terminado
        for (Thread t: threads) {
            t.join();
        }

        System.out.println("El main ha terminado");

        long endTime = System.nanoTime();

        System.out.println((endTime - startTime)/1000);
    }
}
