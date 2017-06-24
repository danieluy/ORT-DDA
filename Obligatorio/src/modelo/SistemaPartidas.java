package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mappers.MapperPartida;
import persistencia.BaseDatos;
import persistencia.Persistencia;

public class SistemaPartidas implements Observer {

  private ArrayList<Partida> partidas;

  public SistemaPartidas() {
    partidas = new ArrayList();
  }

  public Partida crearPartida(Jugador jugador) throws PartidaException, ApuestaException {
    if (jugador.puedeApostar(Partida.APUESTA_INICIAL)) {
      // si no existen partidas creo la primera
      if (partidas.size() > 0) {
        // si la ultima partida no está llena la completo
        Partida ultimaPartida = partidas.get(partidas.size() - 1);
        if (ultimaPartida.getJugador2() == null)
          ultimaPartida.setJugador2(jugador);
        else
          registrarPartida(jugador);
      }
      else
        registrarPartida(jugador);
      return partidas.get(partidas.size() - 1);
    }
    throw new PartidaException("Para jugar es necesario un saldo mínimo de $" + Partida.APUESTA_INICIAL);
  }

  private void registrarPartida(Jugador jugador) throws PartidaException {
    Partida partida = new Partida(jugador);
    partida.addObserver(this);
    partidas.add(partida);
  }

  public void purgarPartidas() {
    ArrayList<Integer> purgar = new ArrayList();
    for (int i = 0; i < partidas.size(); i++)
      if (!partidas.get(i).iniciada())
        purgar.add(i);
    for (int j : purgar)
      partidas.remove(j);
    Fachada.getInstancia().notificar(Fachada.Eventos.listaPartidasActualizada);
  }

  public boolean hayJuegosActivos() {
    for (Partida partida : partidas)
      if (!partida.terminada())
        return true;
    return false;
  }

  public ArrayList<Partida> getPartidas() {
    return partidas;
  }

  protected void guardarPartida(Partida partida) {
    System.out.println("Guardando partida...");
    BaseDatos bd = BaseDatos.getInstancia();
    String url = "jdbc:mysql://localhost/obligatorio_203752";

    bd.conectar(url, "root", "root");

    MapperPartida map = new MapperPartida();
    map.setPartida(partida);

    Persistencia p = Persistencia.getInstancia();
    p.save(map);

    bd.desconectar();

    System.out.println("Partida guardada!");
  }

  @Override
  public void update(Observable observer, Object evento) {
    Fachada.getInstancia().notificar(Fachada.Eventos.listaPartidasActualizada);
    if (evento == Partida.Eventos.partidaTerminada) {
      guardarPartida((Partida) observer);
      observer.deleteObserver(this);
    }
    if (evento == Partida.Eventos.partidaCancelada)
      purgarPartidas();
  }

}
