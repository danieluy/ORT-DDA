package controladores;

import modelo.Jugador;
import modelo.Usuario;
import vistas.partida.PartidaVista;

public class PartidaControlador {

    private Jugador[] jugadores = new Jugador[2];
    private PartidaVista vista;

    public PartidaControlador(PartidaVista vista) {
        this.vista = vista;
    }

    public void setJugador(Jugador jugador) {
        if (jugadores[0] == null) {
            jugadores[0] = jugador;
        } else {
            jugadores[1] = jugador;
        }
    }
}
