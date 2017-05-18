package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import modelo.Fachada;
import modelo.PartidaException;
import vista.FrameInicio;

public class InicioControlador {

  InicioVista vista;
  Fachada modelo = Fachada.getInstancia();

  public InicioControlador(InicioVista vista) {
    this.vista = vista;

  }

  public int validarCerrar() {
    try {
      modelo.validarCerrarInicio();
      return JFrame.EXIT_ON_CLOSE;
    }
    catch (PartidaException ex) {
      vista.mostrarError(ex.getMessage());
      return JFrame.DO_NOTHING_ON_CLOSE;
    }
  }

}
