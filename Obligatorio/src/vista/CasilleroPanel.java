package vista;

import java.awt.Color;
import modelo.CasilleroException;
import modelo.Jugador;

public interface CasilleroPanel {

    public Color getColor();

    public void destapar(Jugador jugador) throws CasilleroException;

}
