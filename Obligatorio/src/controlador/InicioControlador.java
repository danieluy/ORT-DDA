package controlador;

import javax.swing.JFrame;
import modelo.Modelo;

public class InicioControlador {

  InicioVista vista;
  Modelo modelo = Modelo.getInstancia();

  public InicioControlador(InicioVista vista) {
    this.vista = vista;
  }

  public int validarCerrar() {
    if (modelo.hayJuegosActivos()) {
      vista.mostrarError("Hay juegos activos");
      return JFrame.DO_NOTHING_ON_CLOSE;
    }
    else
      return JFrame.EXIT_ON_CLOSE;
  }

}
