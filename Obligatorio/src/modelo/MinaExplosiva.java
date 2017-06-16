package modelo;

public class MinaExplosiva extends Mina {

  public MinaExplosiva(){
    super("E");
  }

  @Override
  public void activar(Partida partida) {
    partida.terminar();
  }

}
