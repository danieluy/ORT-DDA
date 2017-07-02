package controlador;

import modelo.Modelo;
import modelo.Jugador;
import modelo.Administrador;
import modelo.Usuario;
import modelo.UsuarioException;

public class LoginControlador {

  private Modelo modelo = Modelo.getInstancia();
  private LoginVista vista;

  public LoginControlador(LoginVista vista) {
    this.vista = vista;
  }

  public void login(String usuario, String password, Enum tipoUsuario) {
    if (tipoUsuario == Usuario.TiposUsuario.jugador)
      try {
        Jugador jugador = modelo.loginJugador(usuario, password);
        vista.loginJugadorOk(jugador);
      }
      catch (UsuarioException e) {
        vista.loginError(e.getMessage());
      }
    if (tipoUsuario == Usuario.TiposUsuario.administrador)
      try {
        Administrador administrador = modelo.loginAdministrador(usuario, password);
        vista.loginAdministradorOk(administrador);
      }
      catch (UsuarioException e) {
        vista.loginError(e.getMessage());
      }
  }
}
