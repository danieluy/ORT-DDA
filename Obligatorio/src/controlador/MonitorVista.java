package controlador;

import java.util.ArrayList;

public interface MonitorVista {
  public void mostrarTablero(int tamano, ArrayList casilleros);
  public void mostrarDatos(String tituloPartida, double pozo, int numeroTurno, String turnoDe);
  public void mostrarError(String mensaje);
}
