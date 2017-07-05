package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mappers.Mapper;
import mappers.MapperPartida;
import persistencia.BaseDatos;
import persistencia.Persistencia;

public class SistemaPartidas implements Observer {
  
  private BaseDatos bd = BaseDatos.getInstancia();
  private Persistencia persistencia = Persistencia.getInstancia();
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
    Modelo.getInstancia().notificar(Modelo.Eventos.listaPartidasActualizada);
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

    bd.conectar(Config.BD_URL, Config.BD_USUARIO, Config.BD_PASSWORD);

    MapperPartida map = new MapperPartida();
    map.setPartida(partida);

    Persistencia p = Persistencia.getInstancia();
    p.save(map);
    
  }

  public void cargarPartidas() throws UsuarioException {
    bd.conectar(Config.BD_URL, Config.BD_USUARIO, Config.BD_PASSWORD);
    Mapper map = new MapperPartida();
    partidas = persistencia.selectAll(map);
    bd.desconectar();
  }

  @Override
  public void update(Observable observer, Object evento) {
    Modelo.getInstancia().notificar(Modelo.Eventos.listaPartidasActualizada);
    if (evento == Partida.Eventos.partidaTerminada) {
      Partida p = (Partida) observer;
      guardarPartida(p);
      Modelo.getInstancia().guardarJugador(p.getJugador1());
      Modelo.getInstancia().guardarJugador(p.getJugador2());
      observer.deleteObserver(this);
    }
    if (evento == Partida.Eventos.partidaCancelada)
      purgarPartidas();
  }

}
