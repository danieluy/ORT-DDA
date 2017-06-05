package vista;

import javax.swing.JButton;

public class BotonCasillero extends JButton {

  private CasilleroPanel casillero;

  public BotonCasillero(CasilleroPanel casillero) {
    this.casillero = casillero;
    mostrar();
  }

  private void mostrar() {
    setBackground(casillero.getColor());
    setText(casillero.getTipoMina());
  }

  public CasilleroPanel getCasillero() {
    return casillero;
  }

}
