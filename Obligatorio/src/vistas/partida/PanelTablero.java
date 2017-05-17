package vistas.partida;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import vistas.partida.BotonCasillero;
import vistas.partida.CasilleroPanel;

public class PanelTablero extends JPanel {

    public void mostrarTablero(int tamaño, ArrayList<CasilleroPanel> casilleros, ActionListener listener) {
        GridLayout gridLayout = new GridLayout(tamaño, tamaño);
        setLayout(gridLayout);
        for (CasilleroPanel casillero : casilleros) {
            BotonCasillero botonCasillero = new BotonCasillero(casillero);
            botonCasillero.addActionListener(listener);
            add(botonCasillero);
        }
    }

}
