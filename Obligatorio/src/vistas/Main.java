package vistas;

import modelo.Administrador;
import modelo.Fachada;
import modelo.Jugador;

public class Main {

    public static void main(String[] args) {

        System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

        Fachada modelo = Fachada.getInstancia();

        modelo.addJugador(new Jugador("Tyler", "Tyler Durden", "tfc"));
        modelo.addJugador(new Jugador("Marla", "Marla Singer", "tfc"));
        
        modelo.addAdministrador(new Administrador("Daniel", "Daniel Sosa", "pass"));
        
        new InicioFrame().setVisible(true);
    }

}
