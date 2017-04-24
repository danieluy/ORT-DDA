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
public class AlarmaSilenciosa implements EscuchadorSensor{

    @Override
    public void hayActividad() {
        llamar("HAY LADRONES");
    }

    @Override
    public void hayReposo() {
        llamar("TODO TRANQUILO");
    }

    private void llamar(String msg) {
        System.out.println("ALARMA SILENCIOSA>LLAMADA:" + msg);
    }
    
}
