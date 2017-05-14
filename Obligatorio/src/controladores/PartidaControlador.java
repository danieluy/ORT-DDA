package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        }
        catch (PartidaException ex) {
            vista.mostrarError(ex.getMessage());
        }
        partida.addObserver(this);
//        Si es el jugador 1 preguntamos tamaño de tablero
//        Si es el jugador 2 y ...
        if (partida.getJugador2() == jugador) {
//            ... ya está creado el tablero, empezamos
            if (partida.tableroCreado()) {
                iniciarTablero();
            }
//            ... sino, esperamos
            else {
                vista.mostrarEspera("Esperando por " + partida.getJugador1().getNombreCompleto());
            }
        }
        setTituloFrame();
    }

    private void setTituloFrame() {
        if (partida.estaIniciada()) {
            vista.setTitulo(partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto());
        }
        else {
            vista.setTitulo(partida.getJugador1().getNombreCompleto() + " esperando oponente");
        }
    }

    public void setTamanoTablero(String str_tamano) {
        try {
            partida.setTamanoTablero(Integer.parseInt(str_tamano));
        }
        catch (PartidaException ex) {
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

    private void iniciarTablero() {
        vista.iniciarTablero();
        vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento == Partida.Eventos.partidaLlena) {
            setTituloFrame();
        }
        if (evento == Partida.Eventos.tableroCreado) {
            iniciarTablero();
        }
        if (evento == Partida.Eventos.movimientoEfectuado) {
            vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
        }
    }
}
