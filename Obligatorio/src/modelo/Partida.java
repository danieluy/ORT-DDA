package modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Partida extends Observable {

    private static String[] colores = {"#2593c6", "#c69824"};
    private ArrayList<Apuesta> apuestas;
    private Jugador[] jugadores = new Jugador[2]; // Asegura el límite de dos jugadores
    private Tablero tablero;
    private boolean iniciada = false;

    public enum Eventos {
        partidaIniciada
    }

    private void notificar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Partida(Jugador jugador1) {
        jugadores[0] = jugador1;
        jugador1.setPartida(this);
    }

    public Jugador getJugador1() {
        return jugadores[0];
    }

    public Jugador getJugador2() {
        return jugadores[1];
    }

    public void setJugador2(Jugador jugador) {
        jugadores[1] = jugador;
        iniciarPartida();
    }

    private void iniciarPartida() {
        iniciada = true;
        notificar(Eventos.partidaIniciada);
    }

    public boolean isIniciada() {
        return iniciada;
    }
    
    
}
