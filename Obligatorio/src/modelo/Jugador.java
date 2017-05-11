package modelo;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Jugador extends Usuario {

  private Color color;
  private ArrayList<Apuesta> apuestas;
  private Partida partida;
  private ArrayList<Movimiento> movimientos;

  public Jugador(String nombre, String nombreCompleto, String password) {
    super(nombre, nombreCompleto, password);
  }

  public Jugador(String usuario) {
    super(usuario);
  }

  public void setPartida(Partida partida) {
    this.partida = partida;
  }

  public boolean tienePartida() {
    return partida != null;
  }

  public void abandonarPartida() {
    partida = null;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
