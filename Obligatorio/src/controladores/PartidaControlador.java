package controladores;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Partida;
import modelo.PartidaException;
import vistas.partida.CasilleroPanelTablero;
import vistas.partida.PartidaVista;

public class PartidaControlador implements Observer {

  private Fachada modelo = Fachada.getInstancia();
  private PartidaVista vista;
  private Partida partida;
  private int tamano;

  public PartidaControlador(PartidaVista vista) {
    this.vista = vista;
  }

  public void iniciarPartida(Jugador jugador) {
    partida = modelo.iniciarPartida(jugador);
    partida.addObserver(this);
    setTituloFrame();
  }

  private void setTituloFrame() {
    if (partida.isIniciada()) {
      vista.setTitulo(partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto());
    } else {
      vista.setTitulo(partida.getJugador1().getNombreCompleto() + " esperando oponente");
    }
  }

  public void setTamanoTablero(String str_tamano) {
    try { // corresponde verificar esto acá ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
      int tamano = Integer.parseInt(str_tamano);
      partida.setTamanoTablero(tamano);
//      ArrayList<CasilleroPanelTablero> casilleros = partida.getCasilleros(); // ArrayList<Casillero> cannot be converted to ArrayList<CasilleroPanelTablero> ????????????????????????????????
//      vista.mostrarTablero(tamano, casilleros);
    } catch (PartidaException pex) {
      System.out.println(pex.getMessage());
      vista.mostrarError(pex.getMessage());
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      vista.mostrarError("El tamaño del tablero debe ser una número entero mayor que " + Partida.TAMANO_MINIMO);
    }
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento == Partida.Eventos.partidaIniciada) {
      setTituloFrame();
    }
  }
}
