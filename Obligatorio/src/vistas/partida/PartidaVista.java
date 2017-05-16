package vistas.partida;

import java.util.ArrayList;
import modelo.Casillero;

public interface PartidaVista {

    public void setTitulo(String titulo);

    public void mostrarError(String string);

    public void mostrarTablero(int tamano, ArrayList casilleros);

    public void mostrarEspera(String mensaje);

    public void mostrarDatos(String tituloPartida, String turno, double saldo, double pozo, int numeroTurno);
}
