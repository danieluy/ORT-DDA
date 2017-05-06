package modelo;

import java.util.ArrayList;

public class Tablero {

    ArrayList<Movimiento> movimientos;
    ArrayList<Casillero> casilleros;
    ArrayList<Mina> minas;

    public Tablero(Mina mina) {
        movimientos = new ArrayList();
        casilleros = new ArrayList();
        minas = new ArrayList();
        minas.add(mina);
    }

}
