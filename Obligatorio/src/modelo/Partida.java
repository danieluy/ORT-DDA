package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Color;
import vista.PanelCasillero;

public class Partida extends Observable {

    public static final int TAMANO_MINIMO = 3;
    public static final int TAMANO_MAXIMO = 10;
    public static final double APUESTA_INICIAL = 10;
    private boolean termino = false;
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
        tableroCreado, partidaLlena, partidaTerminada, movimientoEfectuado, partidaIniciada, apuestaRealizada, apuestaPaga, apuestaAumentada, jugadorSeHaRendido
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
        iniciarPartidaIf();
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
        plantarMina();
        notificar(Eventos.tableroCreado);
        iniciarPartidaIf();
    }

    private void iniciarPartidaIf() throws ApuestaException {
        if (estaIniciada()) {
            iniciarApuestas();
            notificar(Eventos.partidaIniciada);
        }
    }

    public void rendirse(Jugador jugador) {
        if (estaIniciada()) {
            termino = true;
            Jugador ganador = getOponente(jugador);
            ganador.setSaldo(ganador.getSaldo() + pozo);
            notificar(Eventos.jugadorSeHaRendido);
        }
    }

    public void terminarPartida() {
        if (estaIniciada()) {
            termino = true;
            if (esTurnoDe(jugador1)) {
                jugador1.setSaldo(jugador1.getSaldo() + pozo);
            }
            else {
                jugador2.setSaldo(jugador2.getSaldo() + pozo);
            }
            notificar(Eventos.partidaTerminada);
        }
    }

    public boolean estaIniciada() {
        return (jugador2 != null && tamano >= TAMANO_MINIMO && !termino);
    }

    private void iniciarApuestas() throws ApuestaException {
        apostar(jugador1, APUESTA_INICIAL);
        pagarApuesta(jugador2);
    }

    public void apostar(Jugador jugadorApuesta, double monto) throws ApuestaException {
        if (estaIniciada()) {
            apuesta = new Apuesta(jugadorApuesta, getOponente(jugadorApuesta), monto);
            pozo += monto;
            notificar(Eventos.apuestaRealizada);
        }
    }

    public void pagarApuesta(Jugador jugadorPaga) throws ApuestaException {
        if (estaIniciada() && !apuesta.estaPaga()) {
            apuesta.pagar(jugadorPaga);
            pozo += apuesta.getApostado();
            notificar(Eventos.apuestaPaga);
        }
    }

    public void subirApuesta(Jugador jugador, double monto) throws ApuestaException {
        if (estaIniciada() && !apuesta.estaPaga()) {
            apuesta.subir(jugador, monto);
            pozo += (apuesta.getApostado() + monto);
            notificar(Eventos.apuestaAumentada);
        }
    }

    private Jugador getOponente(Jugador jugador) {
        if (jugador == jugador1) {
            return jugador2;
        }
        else {
            return jugador1;
        }
    }

    private void plantarMina() {
        if (movimientos.size() % 2 == 0) {
            boolean minaColocada = false;
            while (!minaColocada) {
                int indice = (int) Math.round(Math.random() * ((tamano * tamano) - 1));
                if (!casilleros.get(indice).tieneMina()) {
                    casilleros.get(indice).setMina(new Mina());
                    minaColocada = true;
                }
            }
        }
//        contadorMinas();
    }
//    Solo para desarrollo
    private void contadorMinas() {
        int minas = 0;
        for (Casillero casillero : casilleros) {
            if (casillero.tieneMina()) {
                minas++;
            }
        }
        System.out.println("Minas: " + minas);
    }

    public boolean tableroCreado() {
        return tamano >= TAMANO_MINIMO;
    }

    public void destapar(PanelCasillero casilleroPanel, Jugador jugador) throws PartidaException, CasilleroException, ApuestaException {
        if (estaIniciada()) {
            if (!esTurnoDe(jugador)) {
                throw new PartidaException("Movimiento fuera de turno");
            }
            if (!apuesta.estaPaga()) {
                throw new ApuestaException("Apuesta en curso");
            }
            Casillero casillero = (Casillero) casilleroPanel;
            casillero.destapar(jugador);
            movimientos.add(new Movimiento(casillero, jugador, pozo));
            if (casillero.tieneMina()) {
                terminarPartida();
            }
            else {
                plantarMina();
            }
            notificar(Eventos.movimientoEfectuado);
        }
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
        return cantMov < 2 ? 0 : (cantMov - (cantMov % 2)) / 2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public boolean haTerminado() {
        return termino;
    }
}
