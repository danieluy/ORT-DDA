/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Contador;
import modelo.ContadorException;
import vista.VistaContadorUno;

/**
 *
 * @author docenteFI
 */
public class ControladorContador implements Observer{
    
    private Contador modelo = Contador.getInstancia();
    private VistaContador vista;

    public ControladorContador(VistaContador vista) {
        this.vista = vista;
        mostrarValor();
        modelo.addObserver(this);
        
    }
    private void mostrarValor(){
        int v = modelo.getValor();
        vista.mostrarValor(v + "");
    }
    
    public void sumar() {
        modelo.sumar();
        mostrarValor();
    }

    public void restar() {
        try {
            modelo.restar();
            mostrarValor();
        } catch (ContadorException ex) {
            vista.mostrarError(ex.getMessage());
        }

    }

    @Override
    public void update(Observable o, Object evento) {
        
        if(evento.equals(Contador.Eventos.cambioValor)){
            mostrarValor();
        }
    }
}
