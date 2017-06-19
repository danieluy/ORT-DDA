package modelo;

public class MinaSuerte extends Mina {

  public MinaSuerte(){
    super("S");
  }

  @Override
  public void activar(Partida partida) {
    Jugador jugador = partida.getJugadorTurno();
    jugador.setSaldo(jugador.getSaldo() * 1.1);
    partida.continuar();
  }
  
}