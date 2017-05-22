package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import vista.BotonCasillero;
import vista.CasilleroPanel;

public class TableroPanel extends JPanel {

  public void mostrarTablero(int tamaño, ArrayList<CasilleroPanel> casilleros, ActionListener listener) {
    GridLayout gridLayout = new GridLayout(tamaño, tamaño);
    setLayout(gridLayout);
    for (CasilleroPanel casillero : casilleros) {
      BotonCasillero botonCasillero = new BotonCasillero(casillero);
      if (listener != null) {
        botonCasillero.addActionListener(listener);
      }
      add(botonCasillero);
    }
  }

}
