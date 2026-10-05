package org.ies.tierno.aparcamiento;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try (var es = Executors.newFixedThreadPool(3)) {
            var aparcamiento = new Aparcamiento();
            for (int i = 0; i < 8; i++) {
                int numCoche = i;

                es.submit(() -> {
                    aparcamiento.aparcar(numCoche);
                });

            }
        }
    }
}
