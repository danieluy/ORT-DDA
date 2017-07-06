package vista;

import modelo.Config;
import modelo.Modelo;
import modelo.UsuarioException;
import persistencia.BaseDatos;

public class Main {

  private static Modelo modelo = Modelo.getInstancia();

  public static void main(String[] args) throws UsuarioException {

    System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

    BaseDatos bd = BaseDatos.getInstancia();
    bd.conectar(Config.BD_URL, Config.BD_USUARIO, Config.BD_PASSWORD);
    
    modelo.cargarJugadores();
    modelo.cargarPartidas();

    new InicioFrame().setVisible(true);

  }

}
