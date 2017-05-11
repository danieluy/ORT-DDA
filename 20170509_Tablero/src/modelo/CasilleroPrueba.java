/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import vista.CasilleroPanelTablero;

/**
 *
 * @author docenteFI
 */
public class CasilleroPrueba implements CasilleroPanelTablero{
    
    private Movimiento movimiento;

    @Override
    public Color getColor() {
        if(movimiento==null)
            return Color.GRAY;
        else return movimiento.getColor();
    }

    @Override
    public void destapar() {
        //validaciones...
        movimiento = new Movimiento();
    }
    
}
