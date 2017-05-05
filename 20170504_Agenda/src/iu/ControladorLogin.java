package iu;

import logica.Fachada;
import logica.Usuario;

public class ControladorLogin {

    private Fachada modelo = Fachada.getInstancia();
    private VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }

    public void login(String usuario, String password) {
        Usuario u = modelo.login(usuario, password);
        if (u == null) {
            vista.loginError("Login incorrecto");
        } else {
            vista.loginOk(u);
        }
    }

}
