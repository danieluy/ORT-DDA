package vistas.partida;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import vistas.partida.BotonCasillero;
import vistas.partida.CasilleroPanelTablero;

public class PanelTablero extends JPanel {

  public void mostrarTablero(int tamaño, ArrayList<CasilleroPanelTablero> casilleros, ActionListener listener) {
    GridLayout gl = new GridLayout(tamaño, tamaño);
    setLayout(gl);
    for (CasilleroPanelTablero c : casilleros) {
      BotonCasillero b = new BotonCasillero(c);
      b.addActionListener(listener);
      add(b);
    }

  }

}
