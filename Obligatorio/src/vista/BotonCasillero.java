package vista;

import javax.swing.JButton;

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
