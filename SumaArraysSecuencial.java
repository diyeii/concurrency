package org.ies.tierno.suma;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SumaArraysSecuencial {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[40];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        SumaParcial task1 = new SumaParcial(numbers, 0, 39);

        try(var es = Executors.newFixedThreadPool(4)) {
            es.submit(task1);

        }




        int res = task1.getRes();

        System.out.println(res);
    }
}
