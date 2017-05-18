package controlador;

import modelo.Fachada;

public class ListaPartidasControlador {

  private Fachada modelo;
  private ListaPartidaVista vista;

  public ListaPartidasControlador(ListaPartidaVista vista) {
    this.vista = vista;
    this.modelo = Fachada.getInstancia();
  }
  
  

}
