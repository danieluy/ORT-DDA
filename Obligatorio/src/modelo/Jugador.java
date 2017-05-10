package modelo;

import java.util.ArrayList;

public class Jugador extends Usuario {

    private String color;
    private ArrayList<Apuesta> apuestas;
    private Partida partida;
    private ArrayList<Movimiento> movimientos;

    public Jugador(String nombre, String nombreCompleto, String password) {
        super(nombre, nombreCompleto, password);
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
    
    

}
