package logica;

public class Fachada {

    private Fachada fachada;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaPartidas sistemaPartidas;

    private Fachada() {
        sistemaUsuarios = new SistemaUsuarios();
        sistemaPartidas = new SistemaPartidas();
    }

    public Fachada getInstancia() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    public Jugador loginJugador(String usuario, String password) {
        return sistemaUsuarios.loginJugador(usuario, password);
    }

    public Administrador loginAdministrador(String password, String pass) {
        return sistemaUsuarios.loginAdministrador(password, pass);
    }

    public void logoutJugador(Jugador jugador) {
        sistemaUsuarios.logoutJugador(jugador);
    }

    public void logoutAdministrador(Administrador administrador) {
        sistemaUsuarios.logoutAdministrador(administrador);
    }

}
