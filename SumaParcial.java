package org.ies.tierno.suma;

import java.util.Arrays;

public class SumaParcial implements Runnable {
    private final int[] numbers;
    private final int init;
    private final int end;

    private int res = 0;

    public SumaParcial(int[] numbers, int init, int end) {
        this.numbers = numbers;
        this.init = init;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = init; i <= end; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res += numbers[i];
       }
    }

    public int getRes() {
        return res;
    }
}
