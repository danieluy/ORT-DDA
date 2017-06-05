package modelo;

public class TipoMinaTrampa extends TipoMina {

  public TipoMinaTrampa(){
    super("T");
  }

  @Override
  public void activar(Partida partida) {
    Jugador jugador = partida.getJugadorTurno();
    Jugador oponente = partida.getOponente(jugador);
    double penalizacion = jugador.getSaldo() * 0.25;
    jugador.setSaldo(jugador.getSaldo() - penalizacion);
    oponente.setSaldo(oponente.getSaldo() + penalizacion);
    partida.continuar();
  }
  
}
