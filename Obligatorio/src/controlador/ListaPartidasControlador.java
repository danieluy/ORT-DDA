package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Partida;

public class ListaPartidasControlador implements Observer {

  private Fachada modelo;
  private ListaPartidaVista vistaLista;
  private ArrayList<Partida> partidas;

  public ListaPartidasControlador(ListaPartidaVista vistaLista) {
    this.vistaLista = vistaLista;
    modelo = Fachada.getInstancia();
    modelo.addObserver(this);
    mostrarPartidas();
  }

  private void mostrarPartidas() {
    this.partidas = new ArrayList(modelo.getPartidas());
    ArrayList<String> partidas = new ArrayList();
    for (int i = 0; i < this.partidas.size(); i++) {
      Partida p = this.partidas.get(i);
      Jugador j1 = p.getJugador1();
      String j1Info = j1.getNombre() + " ($ " + j1.getSaldo() + ")";
      Jugador j2 = p.getJugador2();
      String j2Info = j2 != null ? j2.getNombre() + " ($ " + j2.getSaldo() + ")" : "Esperando jugador";
      partidas.add("[" + i + "] [" + (p.haTerminado() ? "Finalizada" : "En Juego") + "] [" + p.getNumeroTurno() + "] " + j1Info + " - " + j2Info + " : $" + p.getPozo());
    }
    vistaLista.mostrarPartidas(partidas);
  }

  public Partida getPartida(int pos) {
    return partidas.get(pos);
  }

  public void salir() {
    modelo.deleteObserver(this);
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento == Fachada.Eventos.listaPartidasActualizada) {
      mostrarPartidas();
    }
  }

}
