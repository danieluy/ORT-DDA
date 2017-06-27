package modelo;

import java.util.ArrayList;

public class Movimiento {

  private Jugador jugador;
  private ArrayList<Casillero> estadoTablero = new ArrayList();
  private double pozo;
  private int numeroTurno;

  public Movimiento(ArrayList<Casillero> casilleros, Jugador jugador, double pozo, int numeroTurno) {
    this.jugador = jugador;
    this.pozo = pozo;
    this.numeroTurno = numeroTurno;
    estadoTablero = clonarEstadoTablero(casilleros);
  }

  public Movimiento() {
  }

  private ArrayList<Casillero> clonarEstadoTablero(ArrayList<Casillero> casilleros) {
    ArrayList<Casillero> estado = new ArrayList();
    for (Casillero c : casilleros) {
      Casillero casillero = new Casillero();
      casillero.setMina(c.getMina());
      casillero.setColor(c.getColor());
      estado.add(casillero);
    }
    return estado;
  }

  public void destaparMinas() {
    for (Casillero c : estadoTablero)
      c.activarMina();
  }
  
  public void restaurarDesdeBD(Jugador jugador, double pozo, int numeroTurno){
    this.jugador = jugador;
    this.pozo = pozo;
    this.numeroTurno = numeroTurno;
  }

//    Getters & Setters
  public Jugador getJugador() {
    return jugador;
  }

  public double getPozo() {
    return pozo;
  }

  public int getNumeroTurno() {
    return numeroTurno;
  }

  public ArrayList<Casillero> getEstadoTablero() {
    return estadoTablero;
  }

  public void addCasilleroDesdeBD(Casillero casillero) {
    estadoTablero.add(casillero);
  }

}
