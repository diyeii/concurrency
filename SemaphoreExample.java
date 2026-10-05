package org.ies.tierno.semaphores;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);   // dos permisos

        semaphore.acquire();

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire();
                Scanner scanner = new Scanner(System.in);

                for (int i = 0; i < 10; i++) {

                    System.out.println("Introduce un número");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
                for (int i = 0; i < 1000; i++) {
                    System.out.println("2");
                }
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        System.out.println("Arrancados");
        semaphore.release();                      // el principal devuelve su permiso
    }
}
