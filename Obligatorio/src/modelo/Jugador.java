package modelo;

import java.awt.Color;
import java.util.ArrayList;

public class Jugador extends Usuario {

    private Color color;
    private ArrayList<Apuesta> apuestas;
    private Partida partida;
    private ArrayList<Movimiento> movimientos;
    private double saldo;

    public Jugador(String nombre, String nombreCompleto, String password, double saldoInicial) {
        super(nombre, nombreCompleto, password);
        saldo = saldoInicial;
    }

    public Jugador(String usuario) {
        super(usuario);
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public boolean tienePartida() {
        return partida != null;
    }

    public void abandonarPartida() {
        partida = null;
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

    public boolean puedeApostar(double saldoMinimo) {
        return saldo >= saldoMinimo;
    }

}
