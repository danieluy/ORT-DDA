package modelo;

import java.util.ArrayList;
import mappers.MapperAdministrador;
import mappers.MapperJugador;
import persistencia.BaseDatos;
import persistencia.Persistencia;

public class SistemaUsuarios {

  private ArrayList<Jugador> jugadores = new ArrayList();
  private ArrayList<Administrador> administradores = new ArrayList();
  private Persistencia persistencia = Persistencia.getInstancia();
  private BaseDatos bd = BaseDatos.getInstancia();

  public Jugador loginJugador(String usuario, String password) throws UsuarioException {
    for (Jugador jugador : jugadores)
      if (jugador.getNombre().equalsIgnoreCase(usuario) && jugador.getPassword().equals(password)) {
        jugadorPuedeHacerLogin(jugador);
        return jugador;
      }
    throw new UsuarioException("Usuario y/o contraseña incorrectos");
  }

  public Administrador loginAdministrador(String usuario, String password) throws UsuarioException {
    for (Administrador administrador : administradores)
      if (administrador.getNombre().equalsIgnoreCase(usuario) && administrador.getPassword().equals(password))
        return administrador;
    throw new UsuarioException("Usuario y/o contraseña incorrectos");
  }

  private void jugadorPuedeHacerLogin(Jugador jugador) throws UsuarioException {
    if (jugador.tienePartida())
      throw new UsuarioException("El jugador " + jugador.getNombre() + " ya se encuantra en el sistema");
  }

  public void logoutJugador(Jugador jugador) {
    jugador.abandonarPartida();
  }

  public void addJugador(Jugador jugador) throws UsuarioException {
    jugador.validar();
    jugadores.add(jugador);
  }

  public void addAdministrador(Administrador administrador) throws UsuarioException {
    administrador.validar();
    administradores.add(administrador);
  }

  void logoutAdministrador(Administrador administrador) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public void cargarUsuarios() throws UsuarioException {
    cargarJugadores();
    cargarAdministradores();
  }

  public void guardarJugador(Jugador u) {
    MapperJugador map = new MapperJugador();
    map.setUsuario(u);
    persistencia.save(map);
  }

  private void cargarJugadores() throws UsuarioException {
    MapperJugador map = new MapperJugador();
    ArrayList<Jugador> jugadores_bd = persistencia.selectAll(map);
    for (Jugador j : jugadores_bd)
      addJugador((Jugador) j);
  }

  private void cargarAdministradores() throws UsuarioException {
    MapperAdministrador map = new MapperAdministrador();
    ArrayList<Administrador> administradores_bd = persistencia.selectAll(map);
    for (Administrador a : administradores_bd)
      addAdministrador((Administrador) a);
  }

  public Jugador getByOid(int oid) {
    for (Jugador j : jugadores)
      if (j.getOid() == oid)
        return j;
    return null;
  }

}
