package vista;

import javax.swing.JButton;

public class BotonCasillero extends JButton {

    private PanelCasillero casillero;

    public BotonCasillero(PanelCasillero casillero) {
        this.casillero = casillero;
        setBackground(casillero.getColor());
    }

    public PanelCasillero getCasillero() {
        return casillero;
    }

}
