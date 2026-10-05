package org.ies.tierno.aparcamiento;

import java.util.Enumeration;
import java.util.concurrent.Semaphore;
import java.util.random.RandomGenerator;

public class Aparcamiento {

    private final Semaphore semaphore = new Semaphore(3);

    public void aparcar(int coche) {

        try {
            System.out.println("Coche " + coche + " llega");

            semaphore.acquire();

            System.out.println("Aparcando coche "+ coche +", quedan " + semaphore.availablePermits() + " plazas libres");
            Thread.sleep(RandomGenerator.getDefault().nextInt(1000, 3000));

            System.out.println("   Coche " + coche + " se va");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}