package modelo;

public abstract class TipoMina {
  
  private String descripcion;

  public TipoMina(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public String getDescripcion() {
    return descripcion;
  }

  public abstract void activar(Partida partida);
  
}