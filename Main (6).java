package org.ies.tierno.runners;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numRunners = 3;
        Semaphore semaphore = new Semaphore(0);

        try(var es = Executors.newFixedThreadPool(numRunners)) {
            for (int i = 0; i < numRunners; i++) {
                es.submit(new Runner(i + 1, semaphore));
            }

            Thread.sleep(3000);

            semaphore.release(numRunners);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
