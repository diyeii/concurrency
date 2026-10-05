package org.ies.tierno.lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;

public class ExampleList {
    public static void main(String[] args) {
        List<Integer> numbers = new Vector<>();
        try(var es = Executors.newFixedThreadPool(4);) {
            es.submit(() -> {
                for (int i = 0; i < 10000; i++) {
                    numbers.add(i);
                }
            });

            es.submit(() -> {
                for (int i = 10000; i < 20000; i++) {
                    numbers.add(i);
                }
            });

            es.submit(() -> {
                for (int i = 20000; i < 30000; i++) {
                    numbers.add(i);
                }
            });

            es.submit(() -> {
                for (int i = 30000; i < 40000; i++) {
                    numbers.add(i);
                }
            });
        }

        System.out.println(numbers.size());



    }
}
