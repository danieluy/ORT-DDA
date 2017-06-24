package vista;

import java.util.ArrayList;
import mappers.MapperAdministrador;
import mappers.MapperJugador;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Jugador;
import modelo.UsuarioException;
import persistencia.BaseDatos;
import persistencia.Persistencia;

public class Main {

  private static Fachada modelo = Fachada.getInstancia();

  public static void main(String[] args) throws UsuarioException {

    System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

    modelo.iniciarJugadores();

    new InicioFrame().setVisible(true);

  }

}
