package modelo;

import java.util.ArrayList;

class Partida {

    private static String[] colores = {"#2593c6", "#c69824"};
    private ArrayList<Apuesta> apuestas;
    private Jugador[] jugadores = new Jugador[2]; // Asegura el límite de dos jugadores
    private Tablero tablero;

    public Partida(Jugador jugador1) {
        jugadores[0] = jugador1;
        jugador1.setPartida(this);
    }
    
}
