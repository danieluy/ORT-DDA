package modelo;

import java.awt.Color;

public class Mina {

  private Color color = Color.RED;
  private TipoMina tipo;
  private String descripcion;
  private TipoMina[] tipos = {
    new MinaExplosiva(),
    new MinaTrampa(),
    new MinaSuerte()
  };

  private void setTipo(int casillerosRestantes) {
    if (casillerosRestantes <= 2)
      tipo = new MinaExplosiva();
    else {
      int indice = (int) Math.round(Math.random() * ((tipos.length) - 1));
      tipo = tipos[indice];
    }
  }

  public Color getColor() {
    return color;
  }

  public String getTipo() {
    return tipo.getDescripcion();
  }

  public void activar(Partida partida) {
    tipo.activar(partida);
  }
  
  public String getDescripcion() {
    return descripcion;
  }

}
