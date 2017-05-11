package modelo;

import java.awt.Color;
import vistas.partida.CasilleroPanelTablero;

public class Casillero implements CasilleroPanelTablero {

  private Movimiento movimiento;
  private Mina mina = null;
  private Color color;

  public Mina getMina() {
    return mina;
  }

  public void setMina(Mina mina) {
    this.mina = mina;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public void destapar() {
//    TODO implementar el método
  }

}
