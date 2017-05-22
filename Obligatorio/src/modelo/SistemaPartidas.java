package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SistemaPartidas implements Observer {

  private ArrayList<Partida> partidas;
  private Fachada fachada;

  public SistemaPartidas() {
    partidas = new ArrayList();
    fachada = Fachada.getInstancia();
  }

  public Partida crearPartida(Jugador jugador) throws PartidaException, ApuestaException {
    if (jugador.puedeApostar(Partida.APUESTA_INICIAL)) {
      // si no existen partidas creo la primera
      if (partidas.size() > 0) {
        // si la ultima partida no está llena la completo
        Partida ultimaPartida = partidas.get(partidas.size() - 1);
        if (ultimaPartida.getJugador2() == null) {
          ultimaPartida.setJugador2(jugador);
        }
        else {
          registrarPartida(jugador);
        }
      }
      else {
        registrarPartida(jugador);
      }
      return partidas.get(partidas.size() - 1);
    }
    throw new PartidaException("Para jugar es necesario un saldo mínimo de $" + Partida.APUESTA_INICIAL);
  }

  private void registrarPartida(Jugador jugador) throws PartidaException {
    Partida partida = new Partida(jugador);
    partida.addObserver(this);
    partidas.add(partida);
  }

  public void validarCerrarInicio() throws PartidaException {
    for (Partida partida : partidas) {
      if (!partida.haTerminado()) {
        throw new PartidaException("Hay juegos activos");
      }
    }
  }

  public ArrayList<Partida> getPartidas() {
    return partidas;
  }

  @Override
  public void update(Observable o, Object evento) {
    Fachada.getInstancia().notificar(Fachada.Eventos.listaPartidasActualizada);
    if (evento == Partida.Eventos.partidaTerminada) {
      o.deleteObserver(this);
    }
  }

}
