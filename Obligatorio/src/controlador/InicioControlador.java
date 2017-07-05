package controlador;

import javax.swing.JFrame;
import modelo.Modelo;

public class InicioControlador {

  InicioVista vista;
  Modelo modelo = Modelo.getInstancia();

  public InicioControlador(InicioVista vista) {
    this.vista = vista;
  }

  public boolean validarCerrar() {
    if (modelo.hayJuegosActivos()) {
      vista.mostrarError("Hay juegos activos");
      return false;
    }
    else
      return true;
  }

}
