package modelo;

import java.util.ArrayList;

public class Fachada {

    private static Fachada instancia = new Fachada();
    private SistemaUsuarios sistemaUsuarios;
    private SistemaPartidas sistemaPartidas;

    private Fachada() {
        sistemaUsuarios = new SistemaUsuarios();
        sistemaPartidas = new SistemaPartidas();
    }

    public static Fachada getInstancia() {
        return instancia;
    }

//    Sistema de Usuarios
    public Jugador loginJugador(String usuario, String password) throws UsuarioException {
        return sistemaUsuarios.loginJugador(usuario, password);
    }

    public Administrador loginAdministrador(String password, String pass) throws UsuarioException {
        return sistemaUsuarios.loginAdministrador(password, pass);
    }

    public void logoutJugador(Jugador jugador) {
        sistemaUsuarios.logoutJugador(jugador);
    }

    public void logoutAdministrador(Administrador administrador) {
        sistemaUsuarios.logoutAdministrador(administrador);
    }

    public void addJugador(Jugador jugador) {
        sistemaUsuarios.addJugador(jugador);
    }

    public void addAdministrador(Administrador administrador) {
        sistemaUsuarios.addAdministrador(administrador);
    }

//    Sistema de Partidas
    public Partida crearPartida(Jugador jugador) throws PartidaException, ApuestaException {
        return sistemaPartidas.crearPartida(jugador);
    }

    public void validarCerrarInicio() throws PartidaException {
        sistemaPartidas.validarCerrarInicio();
    }

    public ArrayList<Partida> getPartidas() {
        return sistemaPartidas.getPartidas();
    }

}
