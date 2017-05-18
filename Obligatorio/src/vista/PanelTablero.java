package vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import vista.BotonCasillero;
import vista.PanelCasillero;

public class PanelTablero extends JPanel {

    public void mostrarTablero(int tamaño, ArrayList<PanelCasillero> casilleros, ActionListener listener) {
        GridLayout gridLayout = new GridLayout(tamaño, tamaño);
        setLayout(gridLayout);
        for (PanelCasillero casillero : casilleros) {
            BotonCasillero botonCasillero = new BotonCasillero(casillero);
            botonCasillero.addActionListener(listener);
            add(botonCasillero);
        }
    }

}
