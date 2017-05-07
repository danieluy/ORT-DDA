package controladores;

import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Partida;
import vistas.partida.PartidaVista;

public class PartidaControlador implements Observer {

    private Fachada modelo = Fachada.getInstancia();
    private PartidaVista vista;
    private Partida partida;

    public PartidaControlador(PartidaVista vista) {
        this.vista = vista;
    }

    public void iniciarPartida(Jugador jugador) {
        partida = modelo.iniciarPartida(jugador);
        partida.addObserver(this);
        setTituloFrame();
    }

    private void setTituloFrame() {
//        System.out.println(partida.isIniciada() ? "Partida iniciada" : "Partida en espera");
        if (partida.isIniciada()) {
            vista.setTitulo(partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto());
        } else {
            vista.setTitulo(partida.getJugador1().getNombreCompleto() + " esperando oponente");
        }
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento == Partida.Eventos.partidaIniciada) {
            setTituloFrame();
        }
    }
}
