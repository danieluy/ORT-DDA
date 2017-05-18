package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import modelo.ApuestaException;
import modelo.CasilleroException;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Partida;
import modelo.PartidaException;
import vista.PanelCasillero;

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
//        Si es el jugador 2 espera
            if (partida.getJugador2() == jugador) {
                if (partida.estaIniciada()) {
                    actualizarPartida();
                }
                else {
                    vista.mostrarEspera("Esperando por " + partida.getJugador1().getNombreCompleto());
                }
            }
            vista.setTitulo(tituloPartida());
        }
        catch (PartidaException | ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
            vista.cerrar();
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

    public void destapar(PanelCasillero casillero) {
        try {
            partida.destapar(casillero, jugador);
        }
        catch (PartidaException | CasilleroException | ApuestaException ex) {
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
        else if(partida.haTerminado()){
            titulo = "Partida finalizada";
        }
        else{
            titulo = partida.getJugador1().getNombreCompleto() + " esperando oponente";
        }
        return titulo;
    }

    private void actualizarPartida() {
        vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
        vista.mostrarDatos(tituloPartida(), getTurno(), jugador.getSaldo(), partida.getPozo(), partida.getApuesta().getTotalApostado(), partida.getNumeroTurno());
    }

    public void salir() {
        partida.deleteObserver(this);
        partida.rendirse(jugador);
        modelo.logoutJugador(jugador);
    }

    public void apostar(String str_monto) {
        try {
            partida.apostar(jugador, Double.parseDouble(str_monto));
        }
        catch (ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
        }
        catch (NumberFormatException ex) {
            vista.mostrarError("El monto apostado debe ser un número");
        }
    }

    public void pagar() {
        try {
            partida.pagarApuesta(jugador);
        }
        catch (ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void subir(String str_monto) {
        try {
            partida.subirApuesta(jugador, Integer.parseInt(str_monto));
        }
        catch (ApuestaException ex) {
            vista.mostrarError(ex.getMessage());
        }
        catch (NumberFormatException ex) {
            vista.mostrarError("El monto apostado debe ser un número");
        }
    }

    private String getInfoFinPartida() {
        if (partida.esTurnoDe(jugador)) {
            return "Has ganado la partida!";
        }
        return "Has perdido";
    }

    @Override
    public void update(Observable o, Object evento) {
        // ya ingresaron ambos jugadores
        if (evento == Partida.Eventos.partidaLlena) {
            vista.setTitulo(tituloPartida());
        }
        // jugador uno ya está y ya inició el tablero
        if (evento == Partida.Eventos.tableroCreado) {
            vista.mostrarEspera("Esperando oponente");
        }
        // ya ingresaron ambos jugadores y ya se inició el tablero, o se efectuó un movimiento
        if (evento == Partida.Eventos.partidaIniciada || evento == Partida.Eventos.movimientoEfectuado) {
            actualizarPartida();
        }
        // estos eventos actualizan solo los datos
        if (evento == Partida.Eventos.apuestaRealizada || evento == Partida.Eventos.apuestaAumentada || evento == Partida.Eventos.apuestaPaga) {
            actualizarPartida();
        }
        if (evento == Partida.Eventos.partidaTerminada) {
            actualizarPartida();
            vista.mostarMensaje(getInfoFinPartida());
        }
        if (evento == Partida.Eventos.jugadorSeHaRendido) {
            actualizarPartida();
            vista.mostarMensaje("Has ganado la partida!");
        }
    }
}
