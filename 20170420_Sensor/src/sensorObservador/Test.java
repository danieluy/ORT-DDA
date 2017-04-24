/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorObservador;

import sensor.*;

/**
 *
 * @author docenteFI
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sensor s = new Sensor();
        s.agregar(new AlarmaSilenciosa());
        s.agregar(new Service());
        s.on();
    }
    
}
