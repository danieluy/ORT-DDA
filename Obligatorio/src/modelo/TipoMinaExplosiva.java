package modelo;

public class TipoMinaExplosiva extends TipoMina {

  public TipoMinaExplosiva(){
    super("E");
  }

  @Override
  public void activar(Partida partida) {
    partida.terminar();
  }

}
