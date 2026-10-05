package org.ies.tierno.account;

import org.ies.tierno.aparcamiento.Aparcamiento;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000);
        try (var es = Executors.newFixedThreadPool(10)) {

            for (int i = 0; i < 10; i++) {
                int numCoche = i;

                es.submit(() -> {
                   if(cuenta.retirar(200)) {
                       System.out.println("He podido retirar 20€");
                   } else {
                       System.out.println("No he podido retirar 20€");
                   }
                });

            }
        }

        System.out.println("Saldo final " + cuenta.getSaldo());
    }
}
