package controladores;

import vistas.login.LoginVista;
import modelo.Fachada;
import vistas.InicioFrame;
import modelo.Jugador;
import modelo.Administrador;

public class LoginControlador {

    private Fachada modelo = Fachada.getInstancia();
    private LoginVista vista;

    public LoginControlador(LoginVista vista) {
        this.vista = vista;
    }

    public void login(String usuario, String password, InicioFrame.tipoUsuario tipoUsuario) {
        if (tipoUsuario == InicioFrame.tipoUsuario.jugador) {
            try {
                Jugador jugador = modelo.loginJugador(usuario, password);
                vista.loginJugadorOk(jugador);
            } catch (Exception e) {
                vista.loginError(e.getMessage());
            }
        }
        if (tipoUsuario == InicioFrame.tipoUsuario.administrador) {
            try {
                Administrador administrador = modelo.loginAdministrador(usuario, password);
                vista.loginAdministradorOk(administrador);
            } catch (Exception e) {
                vista.loginError(e.getMessage());
            }
        }
    }
}
