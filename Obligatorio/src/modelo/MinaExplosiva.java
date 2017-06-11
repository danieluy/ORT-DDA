package modelo;

public class MinaExplosiva extends TipoMina {

  public MinaExplosiva(){
    super("E");
  }

  @Override
  public void activar(Partida partida) {
    partida.terminar();
  }

}
