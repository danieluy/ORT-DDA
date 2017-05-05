package iu;

import logica.Usuario;

public interface LoginVista {
    public void loginOk(Usuario usuario);
    public void loginError(String mensage);
}
