package modelo;

public class TipoMinaSuerte extends TipoMina {

  public TipoMinaSuerte(){
    super("S");
  }

  @Override
  public void activar(Partida partida) {
    Jugador jugador = partida.getJugadorTurno();
    jugador.setSaldo(jugador.getSaldo() * 1.1);
    partida.continuar();
  }
  
}