package org.ies.tierno.account;

public class Cuenta {

    private int saldo;

    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized boolean retirar(int cantidad) {
        try {
            if (saldo >= cantidad) {          // 1. comprobar
                Thread.sleep(50);
                saldo = saldo - cantidad;     // 2. actuar
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSaldo() {
        return saldo;
    }
}
