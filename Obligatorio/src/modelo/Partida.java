package modelo;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.paint.Color;

public class Partida extends Observable {

  public static final int TAMANO_MINIMO = 3;
  private Color[] colores = {Color.LIGHTGREEN, Color.LIGHTBLUE};
  private Apuesta apuesta;
  private int pozo;
  private Jugador[] jugadores = new Jugador[2]; // Asegura el límite de dos jugadores
  private ArrayList<Casillero> casilleros;

  public enum Eventos {
    partidaIniciada
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  public Partida(Jugador jugador1) {
    jugadores[0] = jugador1;
    jugador1.setPartida(this);
    jugador1.setColor(colores[0]);
  }

  public void setJugador2(Jugador jugador2) {
    jugadores[1] = jugador2;
    jugador2.setPartida(this);
    jugador2.setColor(colores[1]);
    iniciarPartida();
  }

  public Jugador getJugador1() {
    return jugadores[0];
  }

  public Jugador getJugador2() {
    return jugadores[1];
  }

  private void iniciarPartida() {
//    validar si se puede iniciar la partida
    notificar(Eventos.partidaIniciada);
  }

  public void setTamanoTablero(int tamano) throws PartidaException {
//    System.out.println("tamano " + tamano);
//    System.out.println("TAMANO_MINIMO " + TAMANO_MINIMO);
//    System.out.println("tamano < TAMANO_MINIMO " + (tamano < TAMANO_MINIMO));
    if (tamano < TAMANO_MINIMO) {
      throw new PartidaException("El tamaño mínimo del tablero es de " + TAMANO_MINIMO + (TAMANO_MINIMO == 1 ? " casillero" : " casilleros"));
    }
    for (int i = 0; i < (tamano * tamano); i++) {
      casilleros.add(new Casillero());
    }
  }

  public ArrayList<Casillero> getCasilleros() {
    return casilleros;
  }

  public boolean isIniciada() {
    return jugadores[1] != null;
  }
}
