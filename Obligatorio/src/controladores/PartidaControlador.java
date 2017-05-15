package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ApuestaException;
import modelo.CasilleroException;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Partida;
import modelo.PartidaException;
import vistas.partida.PartidaVista;
import vistas.partida.CasilleroPanel;

public class PartidaControlador implements Observer {

    private Fachada modelo = Fachada.getInstancia();
    private PartidaVista vista;
    private Partida partida;
    private int tamano;
    private Jugador jugador;

    public PartidaControlador(PartidaVista vista) {
        this.vista = vista;
    }

    public void crearPartida(Jugador jugador) {
        try {
            this.jugador = jugador;
            partida = modelo.crearPartida(jugador);
            partida.addObserver(this);
//        Si es el jugador 1 preguntamos tamaño de tablero
//        Si es el jugador 2 y espera o inicia
            if (partida.getJugador2() == jugador) {
                vista.mostrarEspera("Esperando por " + partida.getJugador1().getNombreCompleto());
            }
            vista.setTitulo(tituloPartida());
        }
        catch (PartidaException | ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void setTamanoTablero(String str_tamano) {
        try {
            partida.setTamanoTablero(Integer.parseInt(str_tamano));
        }
        catch (PartidaException | ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
        }
        catch (NumberFormatException ex) {
            vista.mostrarError("El tamaño del tablero debe ser un número entero (mín = " + Partida.TAMANO_MINIMO + ", máx = " + Partida.TAMANO_MAXIMO);
        }
    }

    public void destapar(CasilleroPanel casillero) {
        try {
            partida.destapar(casillero, jugador);
        }
        catch (PartidaException | CasilleroException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private String getTurno() {
        if (partida.esTurnoDe(jugador)) {
            return "Juegas tu";
        }
        return "Juega tu oponente";
    }

    private String tituloPartida() {
        String titulo;
        if (partida.estaIniciada()) {
            titulo = partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto();
        }
        else {
            titulo = partida.getJugador1().getNombreCompleto() + " esperando oponente";
        }
        return titulo;
    }

    private void actualizarPartida() {
        vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
        vista.mostrarDatos(tituloPartida(), getTurno(), jugador.getSaldo(), partida.getPozo(), partida.getNumeroTurno());
    }

    public void salir() {
        modelo.logoutJugador(jugador);
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento == Partida.Eventos.partidaLlena) {// ya ingresaron ambos jugadores
            vista.setTitulo(tituloPartida());
        }
        if (evento == Partida.Eventos.tableroCreado) {// jugador uno ya está y ya inició el tablero
            vista.mostrarEspera("Esperando oponente");
        }
        if (evento == Partida.Eventos.partidaIniciada) {// ya ingresaron ambos jugadores y ya se inició el tablero
            vista.iniciarTablero();
            actualizarPartida();
        }
        if (evento == Partida.Eventos.movimientoEfectuado) {// se efectuó un movimiento
            actualizarPartida();
        }
    }
}
