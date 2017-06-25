package modelo;

import java.util.ArrayList;

public class Movimiento {

  private int oid;
  private Jugador jugador;
  private ArrayList<Casillero> estadoTablero;
  private double pozo;
  private int numeroTurno;

  public Movimiento(ArrayList<Casillero> casilleros, Jugador jugador, double pozo, int numeroTurno) {
    this.jugador = jugador;
    this.pozo = pozo;
    this.numeroTurno = numeroTurno;
    estadoTablero = clonarEstadoTablero(casilleros);
  }

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
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

}
