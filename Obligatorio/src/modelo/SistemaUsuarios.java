package modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class SistemaUsuarios {

    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Jugador> jugadoresLogueados = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Administrador> administradoresLogueados = new ArrayList();

    public Jugador loginJugador(String usuario, String password) throws UsuarioException {
        jugadorEstaLogueado(usuario);
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(usuario) && jugador.getPassword().equals(password)) {
                jugadoresLogueados.add(jugador);
                return jugador;
            }
        }
        throw new UsuarioException("Usuario y/o contraseña incorrectos");
    }

    public Administrador loginAdministrador(String usuario, String password) throws UsuarioException {
        for (Administrador administrador : administradores) {
            if (administrador.getNombre().equalsIgnoreCase(usuario) && administrador.getPassword().equals(password)) {
                administradoresLogueados.add(administrador);
                return administrador;
            }
        }
        throw new UsuarioException("Usuario y/o contraseña incorrectos");
    }
    
    private void jugadorEstaLogueado(String nombreUsuario) throws UsuarioException{
        Jugador jugador = new Jugador(nombreUsuario);
        if(jugadoresLogueados.contains(jugador)){
            throw new UsuarioException("El jugador " + nombreUsuario + " ya se encuantra en el sistema");
        }
    }

    public void logoutJugador(Jugador jugador) {
        jugadoresLogueados.remove(jugador);
    }

    public void logoutAdministrador(Administrador administrador) {
        jugadoresLogueados.remove(administrador);
    }

    public void addJugador(Jugador jugador) {
        try {
            jugador.validar();
            jugadores.add(jugador);
        } catch (UsuarioException ex) {
            // manejar error
        }
    }

    public void addAdministrador(Administrador administrador) {
        try {
            administrador.validar();
            administradores.add(administrador);
        } catch (UsuarioException ex) {
            // manejar error
        }

    }

}
