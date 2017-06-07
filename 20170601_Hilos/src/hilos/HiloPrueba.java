package hilos;

public class HiloPrueba extends Thread {

  public HiloPrueba(String name) {
    super(name);
  }

  public void run() {
    for (int x = 1; x <= 10; x++) {
      System.out.println("Hilo " + getName() + " : " + x);
      try {
        sleep(1000);
      }
      catch (InterruptedException ex) {
      }
    }
    System.out.println("FIN " + getName());
  }

}
