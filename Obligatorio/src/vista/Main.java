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
  private static Persistencia persistencia = Persistencia.getInstancia();
  private static String url = "jdbc:mysql://localhost/obligatorio_203752";
  private static BaseDatos bd = BaseDatos.getInstancia();

  public static void main(String[] args) throws UsuarioException {

    System.out.println("Diseño y Desarrollo de Aplicaciones - ORT - 2017 - Obligatorio Daniel Sosa");

    bd.conectar(url, "root", "root");

    cargarJugadores();
    cargarAdministradores();

    new InicioFrame().setVisible(true);

    bd.desconectar();
  }

  private static void cargarJugadores() throws UsuarioException {
    MapperJugador map = new MapperJugador();
    ArrayList<Jugador> jugadores = persistencia.selectAll(map);
    for (Jugador j : jugadores)
      modelo.addJugador(new Jugador(j.getNombre(), j.getNombreCompleto(), j.getPassword(), j.getSaldo()));
//    modelo.addJugador(new Jugador("Tyler", "Tyler Durden", "tfc", 100));
//    modelo.addJugador(new Jugador("Marla", "Marla Singer", "tfc", 100));
//    modelo.addJugador(new Jugador("Robert", "Robert Paulson", "tfc", 100));
//    modelo.addJugador(new Jugador("Angel", "Angel Face", "tfc", 100));
//    modelo.addJugador(new Jugador("NoSaldo", "Sin saldo", "tfc", 0));
  }

  private static void cargarAdministradores() throws UsuarioException {
    MapperAdministrador map = new MapperAdministrador();
    ArrayList<Administrador> administradores = persistencia.selectAll(map);
    for (Administrador a : administradores)
      modelo.addAdministrador(new Administrador(a.getNombre(), a.getNombreCompleto(), a.getPassword()));
//    modelo.addAdministrador(new Administrador("Daniel", "Daniel Sosa", "pass"));
//    modelo.addAdministrador(new Administrador("Eduardo", "Eduardo Cardozo", "pass"));
  }

}
