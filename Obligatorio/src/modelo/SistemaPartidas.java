package modelo;

import java.util.ArrayList;

public class SistemaPartidas {

  ArrayList<Partida> partidas = new ArrayList();

  public Partida iniciarPartida(Jugador jugador) {
    // si no existen partidas creo la primera
    if (partidas.size() > 0) {
      // si la ultima partida no está llena la completo, si está llena creo una nueva
      Partida ultimaPartida = partidas.get(partidas.size() - 1);
      if (ultimaPartida.getJugador2() == null) {
        ultimaPartida.setJugador2(jugador);
      } else {
        partidas.add(new Partida(jugador));
      }
    } else {
      partidas.add(new Partida(jugador));
    }
    return partidas.get(partidas.size() - 1);
  }

}
