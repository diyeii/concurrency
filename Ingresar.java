package org.ies.tierno.cuenta;

public class Ingresar implements Runnable {
    private final Cuenta cuenta;

    public Ingresar(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            cuenta.ingresar(1);
            cuenta.sacar(1);
        }
    }
}
