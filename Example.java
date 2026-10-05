package org.ies.tierno.foriexecutors;

import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {
        try (var es = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 100; i++) {
                final int num = i;
                es.submit(() -> System.out.println("Hola " + num));
            }
        }


    }
}
