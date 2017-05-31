package vista;

import modelo.Administrador;
import modelo.Fachada;
import modelo.Jugador;
import modelo.UsuarioException;

public class Main {

  public static void main(String[] args) throws UsuarioException {

    System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

    Fachada modelo = Fachada.getInstancia();

    
    modelo.addJugador(new Jugador("Tyler", "Tyler Durden", "tfc", 100));
    modelo.addJugador(new Jugador("Marla", "Marla Singer", "tfc", 100));
    modelo.addJugador(new Jugador("Robert", "Robert Paulson", "tfc", 100));
    modelo.addJugador(new Jugador("Angel", "Angel Face", "tfc", 100));
    modelo.addJugador(new Jugador("NoSaldo", "Sin saldo", "tfc", 0));

    modelo.addAdministrador(new Administrador("Daniel", "Daniel Sosa", "pass"));
    modelo.addAdministrador(new Administrador("Eduardo", "Eduardo Cardozo", "pass"));

    new InicioFrame().setVisible(true);
    // Added to save empty commit on GIT
  }

}
