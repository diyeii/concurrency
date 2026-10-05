package org.ies.tierno.deadlock;

public class DeadLock {

    private static final Object A = new Object();
    private static final Object B = new Object();

    public static void main(String[] args) {

        // Hilo 1
        new Thread(() -> {
            // Hilo 1 entra y bloqua A
            synchronized (A) {
                dormir(100);
                synchronized (B) {           // espera a B


                    // B estaba bloqueado, hilo 1 espera a que se desbloquee
                    System.out.println("Hilo 1 terminado");
                }
            }
        }).start();

        // Hilo 2
        new Thread(() -> {
            // Hilo 2 entra y bloqua B
            synchronized (A) {           // espera a A
                dormir(100);
                synchronized (B) {

                    // A estaba bloquado, hilo 2 espera a que se desbloquee
                    System.out.println("Hilo 2 terminado");
                }
            }
        }).start();
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}