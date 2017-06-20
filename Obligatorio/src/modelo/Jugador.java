package modelo;

import java.awt.Color;

public class Jugador extends Usuario {

  private Color color;
  private Partida partida;
  private double saldo;

  public Jugador() {
    super();
  }

  public Jugador(String nombre, String nombreCompleto, String password, double saldo) {
    super(nombre, nombreCompleto, password);
    this.saldo = saldo;
  }

  public void abandonarPartida() {
    partida = null;
  }

  public boolean puedeApostar(double montoApuesta) {
    return saldo >= montoApuesta;
  }

  public void puedeJugar() throws JugadorException {
    if (saldo < Partida.APUESTA_INICIAL)
      throw new JugadorException("Saldo insuficiente");
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
  
  
  @Override
  public String toString(){
    return super.toString() + ", saldo: " + saldo;
  }
}
