package modelo;

import java.util.ArrayList;

public class Jugador extends Usuario {

    private String color;
    private ArrayList<Apuesta> apuestas;
    private Partida partida;
    private ArrayList<Movimiento> movimientos;

    public Jugador(String nombre, String nombreCompleto, String password) {
        super(nombre, nombreCompleto, password);
    }

    void setPartida(Partida partida) {
        this.partida = partida;
    }



}
