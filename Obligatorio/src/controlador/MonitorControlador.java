package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Jugador;
import modelo.Movimiento;
import modelo.Partida;

public class MonitorControlador implements Observer {

  private MonitorVista vista;
  private Partida partida;
  private int posicionReproductor;

  public MonitorControlador(MonitorVista vista, Partida partida) {
    this.vista = vista;
    this.partida = partida;
    partida.addObserver(this);
    actualizarEstadoReproductor();
  }

  public void actualizarVista() {
    if (partida.iniciada()) {
      vista.mostrarDatos(tituloPartida(), partida.getPozo(), partida.getNumeroTurno(), getTurnoDe());
      vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
    }
    else
      vista.mostrarError("La partida no ha iniciado aún");
  }

  private String tituloPartida() {
    String titulo;
    if (!partida.iniciada())
      titulo = partida.getJugador1().getNombreCompleto() + " esperando oponente";
    else if (partida.iniciada() && !partida.terminada())
      titulo = partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto();
    else
      titulo = getGanador();
    return titulo;
  }

  private String getGanador() {
    Jugador ganador = partida.getGanador();
    if (ganador == null)
      return "Partida finalizada. Ganador deconocido";
    return ganador.getNombreCompleto() + " ha ganado la partida";
  }

  private String getTurnoDe() {
    return partida.getJugadorTurno().getNombreCompleto();
  }

  public void salir() {
    partida.deleteObserver(this);
  }

  public void adelante() {
    if (partida.terminada() && posicionReproductor < partida.getMovimientos().size() - 1) {
      posicionReproductor++;
      reproducir();
    }
  }

  public void atras() {
    if (partida.terminada() && posicionReproductor > 0) {
      posicionReproductor--;
      reproducir();
    }
  }

  private void reproducir() {
    if (partida.terminada()) {
      Movimiento movimiento = partida.getMovimientos().get(posicionReproductor);
      String turnoDe = movimiento.getJugador() == null ? "" : movimiento.getJugador().getNombreCompleto();
      vista.mostrarDatos(tituloPartida(), movimiento.getPozo(), movimiento.getNumeroTurno(), turnoDe);
      vista.mostrarTablero(partida.getTamano(), movimiento.getEstadoTablero());
    }
    else
      vista.mostrarError("La partida no ha terminado");
  }

  private void actualizarEstadoReproductor() {
    posicionReproductor = partida.getMovimientos().size() - 1;
  }

  @Override
  public void update(Observable o, Object evento) {
    actualizarVista();
    actualizarEstadoReproductor();
  }

}
