package iu;

import logica.Usuario;

public interface VistaLogin {
    public void loginOk(Usuario u);
    public void loginError(String mensage);
}
