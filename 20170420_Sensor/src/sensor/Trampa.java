/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

/**
 *
 * @author docenteFI
 */
public class Trampa implements EscuchadorSensor{

    @Override
    public void hayActividad() {
        abrir();
    }

    @Override
    public void hayReposo() {
        cerrar();
    }

    private void abrir() {
        System.out.println("TRAMPA>ABRIR");
    }

    private void cerrar() {
        System.out.println("TRAMPA>CERRAR");
    }
    
}
