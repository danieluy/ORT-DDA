package hilos;

import java.util.Observable;

public class ProcesoX extends Observable implements Runnable {

  private String nombre;
  private Thread hilo;
  private boolean correr;
  private boolean finalizado;
  private int x = 1;

  public ProcesoX(String nombre) {
    this.nombre = nombre;
  }

  public enum Eventos {
    estado, valor;
  }

  public void continuar() {
    mostrar();
  }

  public void reset() {
    if (!finalizado) {
      x = 1;
      notificar(Eventos.valor);
    }
  }

  public void terminar() {
    finalizado = true;
    detener();
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  public void mostrar() {
    if (!correr && !finalizado) {
      correr = true;
      hilo = new Thread(this);
      hilo.start();
    }
  }

  public void detener() {
    if (correr) {
      correr = false;
      hilo.interrupt();
      notificar(Eventos.estado);
    }
  }

  public String getName() {
    return nombre;
  }

  public String toString() {
    String fin = "";
    if (finalizado)
      fin = " FIN!";
    return getName() + " : " + x + " [" + correr + "]" + fin;
  }

  @Override
  public void run() {

    for (; x <= 100 && correr; x++) {
      notificar(Eventos.valor);
      try {
        Thread.currentThread().sleep(1000);
      }
      catch (InterruptedException ex) {
        System.out.println("I");
      }
    }
    correr = false;
    notificar(Eventos.estado);
  }

}
