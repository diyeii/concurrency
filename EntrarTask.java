package org.ies.tierno.salas;

public class EntrarTask implements Runnable {
    private final String nombre;
    private final Sala sala;

    public EntrarTask(String nombre, Sala sala) {
        this.nombre = nombre;
        this.sala = sala;
    }

    @Override
    public void run() {
        try {
            sala.entrar(nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
