/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorObservador;

import utilidades.Observable;
import utilidades.Observador;

/**
 *
 * @author docenteFI
 */
public class Service implements Observador{

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sensor.Eventos.mantenimiento)){
            System.out.println("MANDAR TECNICO");
        }
    }
    
    
}
