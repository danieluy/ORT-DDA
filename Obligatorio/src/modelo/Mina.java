package modelo;

import java.awt.Color;

public abstract class Mina {

  private Color color = Color.RED;
  private String tipo;

  protected Mina(String tipo) {
    this.tipo = tipo;
  }

  public Color getColor() {
    return color;
  }

  public String getTipo() {
    return tipo;
  }

  public abstract void activar(Partida partida);

}
