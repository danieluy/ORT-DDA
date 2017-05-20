package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Partida;

public class ListaPartidasControlador {

    private Fachada modelo;
    private ListaPartidaVista vista;

    public ListaPartidasControlador(ListaPartidaVista vista) {
        this.vista = vista;
        this.modelo = Fachada.getInstancia();
        mostrarPartidas();
    }

    private void mostrarPartidas() {
        ArrayList<Partida> rawPartidas = modelo.getPartidas();
        ArrayList<String> partidas = new ArrayList();
        for (int i = 0; i < partidas.size(); i++) {
            Partida p = partidas.get(i);
            partidas.add("[" + i + "] [" + (p.haTerminado() ? "Finalizada" : "En Juego") + "] [" + p.getNumeroTurno() + "]");
        }
        vista.mostrarPartidas(partidas);
    }

}
