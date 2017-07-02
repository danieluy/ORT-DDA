package modelo;

import java.util.ArrayList;
import java.util.Observable;

public class Modelo extends Observable {

  private static Modelo instancia = new Modelo();
  private SistemaUsuarios sistemaUsuarios;
  private SistemaPartidas sistemaPartidas;

  public static enum Eventos {
    listaPartidasActualizada
  }

  public void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  private Modelo() {
    sistemaUsuarios = new SistemaUsuarios();
    sistemaPartidas = new SistemaPartidas();
  }

  public static Modelo getInstancia() {
    return instancia;
  }

//    Sistema de Usuarios
  public void cargarJugadores() throws UsuarioException {
    sistemaUsuarios.cargarUsuarios();
  }

  public void guardarJugador(Jugador u) {
    sistemaUsuarios.guardarJugador(u);
  }

  public Jugador getJugadorByOid(int oid) {
    return sistemaUsuarios.getByOid(oid);
  }

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

  public void addJugador(Jugador jugador) throws UsuarioException {
    sistemaUsuarios.addJugador(jugador);
  }

  public void addAdministrador(Administrador administrador) throws UsuarioException {
    sistemaUsuarios.addAdministrador(administrador);
  }

//    Sistema de Partidas
  public Partida crearPartida(Jugador jugador) throws PartidaException, ApuestaException {
    return sistemaPartidas.crearPartida(jugador);
  }

  public boolean hayJuegosActivos() {
    return sistemaPartidas.hayJuegosActivos();
  }

  public ArrayList<Partida> getPartidas() {
    return sistemaPartidas.getPartidas();
  }

  public void cargarPartidas() throws UsuarioException {
    sistemaPartidas.cargarPartidas();
  }

}
