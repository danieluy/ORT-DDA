package vistas.login;

import modelo.Administrador;
import modelo.Jugador;

public interface LoginVista {
    public void loginJugadorOk(Jugador jugador);
    public void loginAdministradorOk(Administrador administrador);
    public void loginError(String mensage);
}
