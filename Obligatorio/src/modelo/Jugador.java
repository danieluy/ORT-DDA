package modelo;

import java.awt.Color;
import java.util.ArrayList;

public class Jugador extends Usuario {

  private Color color;
  private Partida partida;
  private double saldo;

  public Jugador(String nombre, String nombreCompleto, String password, double saldoInicial) {
    super(nombre, nombreCompleto, password);
    saldo = saldoInicial;
  }

  public void abandonarPartida() {
    partida = null;
  }

  public boolean puedeApostar(double montoApuesta) {
    return saldo >= montoApuesta;
  }

  public void puedeJugar() throws JugadorException {
    if (saldo < Partida.APUESTA_INICIAL) {
      throw new JugadorException("Saldo insuficiente");
    }
  }

//  Getters & Setters
  public void setPartida(Partida partida) {
    this.partida = partida;
  }

  public boolean tienePartida() {
    return partida != null;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

}
