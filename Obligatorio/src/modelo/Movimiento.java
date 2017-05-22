package modelo;

import java.util.ArrayList;
import vista.CasilleroPanel;

public class Movimiento {

  private Jugador jugadorTurno;
  private ArrayList<Casillero> estadoTablero;
  private double pozo;
  private int numeroTurno;

  public Movimiento(ArrayList<Casillero> casilleros, Jugador jugador, double pozo, int numeroTurno) {
    jugadorTurno = jugador;
    this.pozo = pozo;
    this.numeroTurno = numeroTurno;
    estadoTablero = getEstado(casilleros);
  }

  private ArrayList<Casillero> getEstado(ArrayList<Casillero> casilleros) {
    ArrayList<Casillero> estado = new ArrayList();
    for (Casillero c : casilleros) {
      Casillero casillero = new Casillero();
      casillero.setMina(c.getMina());
      casillero.setColor(c.getColor());
      estado.add(casillero);
    }
    return estado;
  }

//    Getters & Setters
  public Jugador getJugadorTurno() {
    return jugadorTurno;
  }

  public double getPozo() {
    return pozo;
  }

  public int getNumeroTurno() {
    return numeroTurno;
  }
  
  public ArrayList<Casillero> getEstadoTablero(){
    return estadoTablero;
  }

  void destaparMinas() {
    for(Casillero c : estadoTablero){
      c.destaparMinas();
    }
  }

}
