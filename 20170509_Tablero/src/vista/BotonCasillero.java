/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;

/**
 *
 * @author docenteFI
 */
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
