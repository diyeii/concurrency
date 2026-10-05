package org.ies.tierno.suma;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumaArraysParallel {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[40];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        SumaParcial task1 = new SumaParcial(numbers, 0, 9);
        SumaParcial task2 = new SumaParcial(numbers, 10, 19);
        SumaParcial task3 = new SumaParcial(numbers, 20, 29);
        SumaParcial task4 = new SumaParcial(numbers, 30, 39);

        var es = Executors.newFixedThreadPool(4);
        es.submit(task1);
        es.submit(task2);
        es.submit(task3);
        es.submit(task4);

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        int res = task1.getRes() + task2.getRes() + task3.getRes() + task4.getRes();

        System.out.println(res);
    }
}
