package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Color;
import vistas.partida.CasilleroPanel;

public class Partida extends Observable {

    public static final int TAMANO_MINIMO = 3;
    public static final int TAMANO_MAXIMO = 10;
    public static final double APUESTA_INICIAL = 10;
    private double pozo = 0;
    private int tamano;
    private Color[] colores = {Color.CYAN, Color.YELLOW};
    private Apuesta apuesta;
    private Jugador[] jugadores = new Jugador[2]; // Asegura el límite de dos jugadores
    private ArrayList<Casillero> casilleros = new ArrayList();
    private ArrayList<Movimiento> movimientos = new ArrayList();

    public enum Eventos {
        tableroCreado, partidaLlena, apuestasIniciadas, partidaTerminada, movimientoEfectuado
    }

    private void notificar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Partida(Jugador jugador1) throws PartidaException {
        jugadores[0] = jugador1;
        jugador1.setColor(colores[0]);
        jugador1.setPartida(this);
    }

    public void setJugador2(Jugador jugador2) throws PartidaException {
        jugadores[1] = jugador2;
        jugador2.setColor(colores[1]);
        jugador2.setPartida(this);
        iniciarApuestas();
        notificar(Eventos.partidaLlena);
    }

    public Jugador getJugador1() {
        return jugadores[0];
    }

    public Jugador getJugador2() {
        return jugadores[1];
    }

    public void setTamanoTablero(int tamano) throws PartidaException {
        if (tamano < TAMANO_MINIMO) {
            throw new PartidaException("El tamaño mínimo del tablero es de " + TAMANO_MINIMO + (TAMANO_MINIMO == 1 ? " casillero" : " casilleros"));
        }
        if (tamano > TAMANO_MAXIMO) {
            throw new PartidaException("El tamaño máximo del tablero es de " + TAMANO_MAXIMO + " casilleros");
        }
        this.tamano = tamano;
        for (int i = 0; i < (tamano * tamano); i++) {
            casilleros.add(new Casillero());
        }
        notificar(Eventos.tableroCreado);
        iniciarApuestas();
    }

    private void iniciarApuestas() throws PartidaException {
        if (estaIniciada()) {
            apuesta = new Apuesta(jugadores[0], jugadores[1], APUESTA_INICIAL);
            apuesta.pagarApuesta(jugadores[1]);
            notificar(Eventos.apuestasIniciadas);
        }
    }

    public boolean estaIniciada() {
        return (jugadores[1] != null && tamano >= TAMANO_MINIMO);
    }

    public boolean tableroCreado() {
        return (tamano >= TAMANO_MINIMO);
    }

    public void destapar(CasilleroPanel casillero, Jugador jugador) throws PartidaException, CasilleroException {
        if (!esTurnoDe(jugador)) {
            throw new PartidaException("Movimiento fuera de turno");
        }
        Casillero c = (Casillero) casillero;
        casillero.destapar(jugador);
        if (c.tieneMina()) {
            terminarPartida();
        }
        movimientos.add(new Movimiento(c, jugador, pozo));
        notificar(Eventos.movimientoEfectuado);
    }

    private void terminarPartida() {
        notificar(Eventos.partidaTerminada);
    }

    private boolean esTurnoDe(Jugador jugador) {
        if (movimientos.size() == 0) {
            return jugador == jugadores[0];
        }
        return jugador != movimientos.get(movimientos.size() - 1).getJugador();
    }

//    Getters & Setters
    public int getTamano() {
        return tamano;
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

}
