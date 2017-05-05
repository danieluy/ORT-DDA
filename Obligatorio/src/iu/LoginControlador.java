package iu;

import logica.Fachada;
import logica.Jugador;

public class LoginControlador {

    private Fachada modelo;
    private LoginVista vista;

    public LoginControlador(LoginVista vista) {
        this.vista = vista;
    }

    protected void loginUsuario(String usuario, String password) {
        Jugador jugador = modelo.loginJugador(usuario, password);
        if(jugador == null){
            
        }
    }

}
