package modelo;

import java.awt.Color;
import vistas.partida.CasilleroPanel;

public class Casillero implements CasilleroPanel {

    private Movimiento movimiento;
    private Mina mina;
    private Color color;

    public Casillero() {
        color = Color.LIGHT_GRAY;
    }

    public Mina getMina() {
        return mina;
    }

    public void setMina(Mina mina) {
        this.mina = mina;
    }

    public boolean tieneMina() {
        return mina != null;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void destapar(Jugador jugador) throws CasilleroException {
        if (!color.equals(Color.LIGHT_GRAY)) {
            throw new CasilleroException("Casillero ya destapado");
        }
        if (tieneMina()) {
            color = mina.getColor();
        }
        else {
            color = jugador.getColor();
        }
    }

}
