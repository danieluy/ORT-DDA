package sensorObservador;

public class Sensor extends utilidades.Observable {

    private boolean actividad;

    public enum Eventos {
        actividad, reposo, mantenimiento
    };

    public void on() {
        System.out.println("ON");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ex) {
        }
        actividad();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ex) {
        }
        reposo();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException ex) {
        }
        mantenimiento();
        System.out.println("FIN");
    }

    private void mantenimiento() {
        System.out.println("MANTENIMIETNO");
        avisar(Eventos.mantenimiento);
    }

    private void actividad() {
        System.out.println("ACTIVIDAD!!!");
        actividad = true;
        avisar(Eventos.actividad);
    }

    private void reposo() {
        System.out.println("...REPOSO...");
        actividad = false;
        avisar(Eventos.reposo);
    }

}
