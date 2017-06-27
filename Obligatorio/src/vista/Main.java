package vista;

import modelo.Fachada;
import modelo.UsuarioException;

public class Main {

  private static Fachada modelo = Fachada.getInstancia();

  public static void main(String[] args) throws UsuarioException {

    System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

    modelo.cargarJugadores();
    modelo.cargarPartidas();

    new InicioFrame().setVisible(true);

  }

}
