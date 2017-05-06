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
            Jugador jugador = modelo.loginJugador(usuario, password);
            if (jugador == null) {
                vista.loginError("Usuario o contraseña incorrectos");
            } else {
                vista.iniciarPartida(jugador);
            }
        }
        if (tipoUsuario == InicioFrame.tipoUsuario.administrador) {
            Administrador administrador = modelo.loginAdministrador(usuario, password);
            if (administrador == null) {
                vista.loginError("Usuario o contraseña incorrectos");
            } else {
                vista.loginAdministradorOk(administrador);
            }
        }
    }
}
