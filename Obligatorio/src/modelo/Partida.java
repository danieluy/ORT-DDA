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
    private int tamano = 0;
    private Color color1 = Color.CYAN;
    private Color color2 = Color.YELLOW;
    private Apuesta apuesta;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Casillero> casilleros = new ArrayList();
    private ArrayList<Movimiento> movimientos = new ArrayList();

    public enum Eventos {
        tableroCreado, partidaLlena, partidaTerminada, movimientoEfectuado, partidaIniciada
    }

    private void notificar(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public Partida(Jugador jugador) throws PartidaException {
        jugador1 = jugador;
        jugador1.setColor(color1);
        jugador1.setPartida(this);
    }

    public void setJugador2(Jugador jugador) throws ApuestaException {
        jugador2 = jugador;
        jugador2.setColor(color2);
        jugador2.setPartida(this);
        notificar(Eventos.partidaLlena);
        iniciarPartida();
    }

    public void setTamanoTablero(int tamano) throws PartidaException, ApuestaException {
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
        agregarMina();
        notificar(Eventos.tableroCreado);
        iniciarPartida();
    }

    private void iniciarPartida() throws ApuestaException {
        if (estaIniciada()) {
            iniciarApuestas();
            notificar(Eventos.partidaIniciada);
        }
    }

    private void iniciarApuestas() throws ApuestaException {
        apuesta = new Apuesta(jugador1, jugador2, APUESTA_INICIAL);
        apuesta.pagarApuesta(jugador2);
    }

    private void agregarMina() {
        if (esTurnoDe(jugador1)) {
            System.out.println("Plantando mina");
            boolean minaColocada = false;
            while (!minaColocada) {
                int indice = (int) Math.round(Math.random() * (tamano * tamano));
                if (casilleros.get(indice).getMina() == null) {
                    casilleros.get(indice).setMina(new Mina());
                    System.out.println("Mina plantada");
                    minaColocada = true;
                }
            }
        }
    }

    public boolean estaIniciada() {
        return (jugador2 != null && tamano >= TAMANO_MINIMO);
    }

    public boolean tableroCreado() {
        return tamano >= TAMANO_MINIMO;
    }

    public void destapar(CasilleroPanel casilleroPanel, Jugador jugador) throws PartidaException, CasilleroException {
        if (!esTurnoDe(jugador)) {
            throw new PartidaException("Movimiento fuera de turno");
        }
        Casillero casillero = (Casillero) casilleroPanel;
        casillero.destapar(jugador);
        movimientos.add(new Movimiento(casillero, jugador, pozo));
        if (casillero.tieneMina()) {
            terminarPartida();
        }
        else {
            agregarMina();
        }
        notificar(Eventos.movimientoEfectuado);
    }

    private void terminarPartida() {
        notificar(Eventos.partidaTerminada);
    }

    public boolean esTurnoDe(Jugador jugador) {
        if (movimientos.size() == 0) {
            return jugador == jugador1;
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

    public double getPozo() {
        return pozo;
    }

    public int getNumeroTurno() {
        int cantMov = movimientos.size();
        return cantMov <= 2 ? 1 : (cantMov - (cantMov % 2)) / 2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
}
