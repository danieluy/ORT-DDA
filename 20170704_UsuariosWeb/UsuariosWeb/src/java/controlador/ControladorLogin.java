package controlador;

import modelo.Modelo;
import modelo.Usuario;

public class ControladorLogin {

  private Modelo modelo = Modelo.getInstancia();
  private VistaLogin vista;
  private Usuario usuario;

  public ControladorLogin(VistaLogin vista) {
    this.vista = vista;
  }

  public void login(String n, String p) {
    usuario = modelo.login(n, p);
    if (usuario != null) {
      vista.ingresar(usuario);
    }
    else
      vista.error("Login incorrecto");
  }

}
