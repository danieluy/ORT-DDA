/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author docenteFI
 */
public class Sensor {
    private boolean actividad;
    private ArrayList<EscuchadorSensor> escuchadores = new ArrayList();
    
    public void agregar(EscuchadorSensor es){
        if(!escuchadores.contains(es)){
            escuchadores.add(es);
        }
    }
    public void quitar(EscuchadorSensor es){
        escuchadores.remove(es);
    }
    private void avisar(){
        for(EscuchadorSensor es:escuchadores){
            if(actividad) es.hayActividad();
            else es.hayReposo();
        }
    }
    public void on(){
        System.out.println("ON");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ex) {}
        actividad();
         try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ex) {}
        reposo();
        System.out.println("FIN");
    }

    private void actividad() {
        System.out.println("ACTIVIDAD!!!");
        actividad=true;
        avisar();
    }

    private void reposo() {
        System.out.println("...REPOSO...");
        actividad=false;
        avisar();
    }
    
}
