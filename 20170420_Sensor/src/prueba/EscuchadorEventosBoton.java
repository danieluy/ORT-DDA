/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author docenteFI
 */
public class EscuchadorEventosBoton implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("DIERON CLICK!!!!");
    }
    
}
