package modelo;

import vistas.partida.CasilleroPanel;

public class Movimiento {
    
    private Jugador jugador;
    private Casillero casillero;
    private double pozo;

    public Movimiento(Jugador jugador) {
        this.jugador = jugador;
    }

    public Movimiento(Casillero casillero, Jugador jugador, double pozo) {
        this.casillero = casillero;
        this.jugador = jugador;
        this.pozo = pozo;
    }

//    Getters & Setters
    public Jugador getJugador() {
        return jugador;
    }

}
