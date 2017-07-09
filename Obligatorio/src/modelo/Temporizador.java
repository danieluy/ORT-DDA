package modelo;

import java.util.Observable;
import java.util.Observer;

public class Temporizador extends Observable implements Runnable {

  private Thread thread;
  private int tiempo_segundos;
  private boolean detenido = true;

  public static enum Eventos {
    tiempo_agotado,
    temporizador_detenido,
    interrupted_exception,
    tiempo
  }

  public Temporizador(int tiempo_segundos, Observer observador) {
    this.tiempo_segundos = tiempo_segundos;
    addObserver(observador);
    iniciar();
  }

  private void iniciar() {
    if (detenido) {
      detenido = false;
      thread = new Thread(this);
      thread.start();
    }
  }

  public void detener() {
    if (!detenido) {
      try {
        detenido = true;
        thread.interrupt();
      }
      catch (SecurityException ex) {
        System.out.println(ex.getMessage());
      }
      finally {
        deleteObservers();
      }
    }
  }

  public void pausar() {
    if (!detenido) {
      try {
        detenido = true;
        thread.interrupt();
      }
      catch (SecurityException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  public void continuar() {
    iniciar();
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  public int getTiempo() {
    return tiempo_segundos;
  }

  @Override
  public void run() {
    while (tiempo_segundos > 0 && !detenido) {
      notificar(Eventos.tiempo);
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
    else {
      notificar(Eventos.tiempo_agotado);
      deleteObservers();
    }
  }

}
