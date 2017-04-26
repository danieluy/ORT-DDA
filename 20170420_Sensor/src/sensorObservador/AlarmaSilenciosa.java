package sensorObservador;

import utilidades.Observable;
import utilidades.Observador;

public class AlarmaSilenciosa implements Observador {

    private void llamar(String msg) {
        System.out.println("ALARMA SILENCIOSA>LLAMADA:" + msg);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {

        if (evento.equals(Sensor.Eventos.actividad)) {
            llamar("HAY LADRONES");
        }
        if (evento.equals(Sensor.Eventos.reposo)) {
            llamar("TODO TRNAQUILO");
        }

    }

}
