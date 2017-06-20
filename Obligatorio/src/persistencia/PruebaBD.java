package persistencia;

import java.util.ArrayList;
import mappers.MapperJugador;
import modelo.Jugador;

public class PruebaBD {

  private static Persistencia persistencia = Persistencia.getInstancia();
  private static String url = "jdbc:mysql://localhost/obligatorio_203752";
  private static BaseDatos bd = BaseDatos.getInstancia();

  public static void main(String[] args) {

    bd.conectar(url, "root", "root");

    leerUsuarios();

    bd.desconectar();
  }

  private static void leerUsuarios() {
    MapperJugador mapU = new MapperJugador();

    ArrayList<Jugador> jugadores = persistencia.selectAll(mapU);

    for (Jugador j : jugadores) {
      System.out.println(j);
    }
  }
}
