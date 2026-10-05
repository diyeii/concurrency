package org.ies.tierno.cuenta;

public class Cuenta {
    private int saldo = 0;

    public synchronized void ingresar(int cantidad) {
        int nuevoSaldo = saldo + cantidad;
        saldo = nuevoSaldo;

    }

    public synchronized void sacar(int cantidad) {
        int nuevoSaldo = saldo - cantidad;
        saldo = nuevoSaldo;

    }

    public int getSaldo() {
        return saldo;
    }
}