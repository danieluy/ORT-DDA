package modelo;

import java.util.Observable;
import java.util.Observer;

public class Temporizador extends Observable implements Runnable {

  private Thread hilo;
  private int tiempo_segundos;
  private boolean detenido = false;

  public static enum Eventos {
    tiempo_agotado,
    temporizador_detenido,
    interrupted_exception
  }

  public Temporizador(int tiempo_segundos, Observer observador) {
    hilo = new Thread();
    this.tiempo_segundos = tiempo_segundos;
    addObserver(observador);
    hilo.start();
  }

  public void detener() {
    detenido = true;
    deleteObservers();
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  @Override
  public void run() {
    while (tiempo_segundos > 0 && !detenido) {
      try {
        Thread.currentThread().sleep(1000);
        tiempo_segundos--;
      }
      catch (InterruptedException ex) {
        System.out.println("InterruptedException: " + ex.getMessage());
        notificar(Eventos.interrupted_exception);
      }
    }
    if (detenido)
      notificar(Eventos.temporizador_detenido);
    else
      notificar(Eventos.tiempo_agotado);
//    deleteObservers();
  }

}
