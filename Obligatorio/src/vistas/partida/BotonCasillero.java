package vistas.partida;

import javax.swing.JButton;
import vistas.partida.CasilleroPanelTablero;

public class BotonCasillero extends JButton {

  private CasilleroPanelTablero casillero;

  public BotonCasillero(CasilleroPanelTablero casillero) {
    this.casillero = casillero;
    setBackground(casillero.getColor());
  }

  public CasilleroPanelTablero getCasillero() {
    return casillero;
  }

}
