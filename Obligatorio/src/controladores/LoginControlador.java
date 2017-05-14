package controladores;

import vistas.login.LoginVista;
import modelo.Fachada;
import vistas.InicioFrame;
import modelo.Jugador;
import modelo.Administrador;
import modelo.Usuario;
import modelo.UsuarioException;

public class LoginControlador {

  private Fachada modelo = Fachada.getInstancia();
  private LoginVista vista;

  public LoginControlador(LoginVista vista) {
    this.vista = vista;
  }

  public void login(String usuario, String password, Usuario.TiposUsuario tipoUsuario) {
    if (tipoUsuario == Usuario.TiposUsuario.jugador) {
      try {
        Jugador jugador = modelo.loginJugador(usuario, password);
        vista.loginJugadorOk(jugador);
      } catch (UsuarioException e) {
        vista.loginError(e.getMessage());
      }
    }
    if (tipoUsuario == Usuario.TiposUsuario.administrador) {
      try {
        Administrador administrador = modelo.loginAdministrador(usuario, password);
        vista.loginAdministradorOk(administrador);
      } catch (UsuarioException e) {
        vista.loginError(e.getMessage());
      }
    }
  }
}
