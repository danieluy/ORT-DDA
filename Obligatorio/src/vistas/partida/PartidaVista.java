package vistas.partida;

import java.util.ArrayList;

public interface PartidaVista {

  public void setTitulo(String titulo);

  public void mostrarError(String string);

  public void mostrarTablero(int tamano, ArrayList<CasilleroPanelTablero> casilleros);
}
