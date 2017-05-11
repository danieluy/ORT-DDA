/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.CasilleroPrueba;
import vista.CasilleroPanelTablero;

/**
 *
 * @author docenteFI
 */
public class ControladorPartida {
    
    private VistaPartida vista;
    private ArrayList<CasilleroPanelTablero> lista;

    public ControladorPartida(VistaPartida vista) {
        this.vista = vista;
        generarCasillerosDePrueba(10);
        vista.mostrarTablero(10,lista);
    }
    public void generarCasillerosDePrueba(int t){
        lista = new ArrayList();
        for(int x=1;x<=(t*t);x++){
            lista.add(new CasilleroPrueba());
        }
        
    }

    public void destapar(CasilleroPanelTablero c) {
        c.destapar(/*aca falta el jugador*/);
        vista.mostrarTablero(10,lista);
        
    }
    
    
}
