package logica;

import java.util.ArrayList;

public class Jugador extends Usuario {

    private Color color;
    private ArrayList<Apuesta> apuestas;
    private Partida partida;
    private ArrayList<Movimiento> movimientos;

    public Jugador(String nombre, String password) {
        super(nombre, password);
    }

}
