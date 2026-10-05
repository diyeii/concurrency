package org.ies.tierno.cuenta;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CuentaMain {
    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta = new Cuenta();

        var es = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            es.submit(new Ingresar(cuenta));
        }

        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(cuenta.getSaldo());

    }
}
