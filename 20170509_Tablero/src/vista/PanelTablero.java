/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author docenteFI
 */
public class PanelTablero extends JPanel {
    
    
    
    public void mostrarTablero(int tamaño,ArrayList<CasilleroPanelTablero> casilleros,ActionListener l){
        GridLayout gl = new GridLayout(tamaño,tamaño);
        setLayout(gl);
        for(CasilleroPanelTablero c:casilleros){
            BotonCasillero b = new BotonCasillero(c);
            b.addActionListener(l);
            add(b);
        }
        
    }


    
}
