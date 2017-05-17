package vistas.partida;

import javax.swing.JButton;
import vistas.partida.CasilleroPanel;

public class BotonCasillero extends JButton {

    private CasilleroPanel casillero;

    public BotonCasillero(CasilleroPanel casillero) {
        this.casillero = casillero;
        setBackground(casillero.getColor());
    }

    public CasilleroPanel getCasillero() {
        return casillero;
    }

}
