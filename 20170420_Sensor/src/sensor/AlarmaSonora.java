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
public class AlarmaSonora implements EscuchadorSensor{

    @Override
    public void hayActividad() {
        sonar();
    }

    @Override
    public void hayReposo() {
        mute();
    }

    private void sonar() {
        System.out.println("ALARMA SONORA>!!!!!!!!!!!");
    }

    private void mute() {
       System.out.println("ALARMA SONORA>................");
    }
    
}
