package controlador;

import java.util.Observable;
import java.util.Observer;
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
    if (partida.haIniciado() || partida.haTerminado()) {
      vista.mostrarDatos(tituloPartida(), partida.getPozo(), partida.getNumeroTurno(), getTurnoDe());
      vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
    }
    else {
      vista.mostrarError("La partida no ha iniciado aún");
    }
  }

  private String tituloPartida() {
    String titulo;
    if (partida.haIniciado()) {
      titulo = partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto();
    }
    else if (partida.haTerminado()) {
      titulo = getGanador();
    }
    else {
      titulo = partida.getJugador1().getNombreCompleto() + " esperando oponente";
    }
    return titulo;
  }

  private String getGanador() {
    if (partida.esTurnoDe(partida.getJugador1())) {
      return partida.getJugador1().getNombreCompleto() + " ha ganado la partida";
    }
    return partida.getJugador2().getNombreCompleto() + " ha ganado la partida";
  }

  private String getTurnoDe() {
    if (partida.esTurnoDe(partida.getJugador1())) {
      return partida.getJugador1().getNombreCompleto();
    }
    return partida.getJugador2().getNombreCompleto();
  }

  public void salir() {
    partida.deleteObserver(this);
  }

  public void adelante() {
    if (partida.haTerminado() && posicionReproductor < partida.getMovimientos().size() - 1) {
      posicionReproductor++;
      reproducir();
    }
  }

  public void atras() {
    if (partida.haTerminado() && posicionReproductor > 0) {
      posicionReproductor--;
      reproducir();
    }
  }

  private void reproducir() {
    if (partida.haTerminado()) {
      Movimiento movimiento = partida.getMovimientos().get(posicionReproductor);
      String turnoDe = movimiento.getJugadorTurno() == null ? "" : movimiento.getJugadorTurno().getNombreCompleto();
      vista.mostrarDatos(tituloPartida(), movimiento.getPozo(), movimiento.getNumeroTurno(), turnoDe);
      vista.mostrarTablero(partida.getTamano(), movimiento.getEstadoTablero());
    }
    else {
      vista.mostrarError("La partida no ha terminado");
    }
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
