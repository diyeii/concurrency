package org.ies.tierno.runners;

import java.util.concurrent.Semaphore;

public class Runner implements Runnable {
    private final int numRunner;
    private final Semaphore semaphore;

    public Runner(int numRunner, Semaphore semaphore) {
        this.numRunner = numRunner;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Preparado corredor " + numRunner);
            semaphore.acquire();
            System.out.println("Corriendo corredor " + numRunner);

            System.out.println("Llega corredor " + numRunner);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
