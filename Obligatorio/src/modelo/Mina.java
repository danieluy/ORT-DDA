package modelo;

import java.awt.Color;

public class Mina {

  private Color color = Color.RED;
  private TipoMina tipo;
  private TipoMina[] tipos = {
    new TipoMinaExplosiva(),
    new TipoMinaTrampa(),
    new TipoMinaSuerte()
  };

  public Mina(int casillerosRestantes) {
    setTipo(casillerosRestantes);
  }

  private void setTipo(int casillerosRestantes) {
    if (casillerosRestantes <= 2)
      tipo = new TipoMinaExplosiva();
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

}
