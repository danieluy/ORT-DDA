package modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class SistemaUsuarios {

    ArrayList<Jugador> jugadores = new ArrayList();
    ArrayList<Jugador> jugadoresLogueados = new ArrayList();
    ArrayList<Administrador> administradores = new ArrayList();
    ArrayList<Administrador> administradoresLogueados = new ArrayList();

    public Jugador loginJugador(String usuario, String password) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(usuario) && jugador.getPassword().equals(password)) {
                jugadoresLogueados.add(jugador);
                return jugador;
            }
        }
        return null;
    }

    public Administrador loginAdministrador(String usuario, String password) {
        for (Administrador administrador : administradores) {
            if (administrador.getNombre().equalsIgnoreCase(usuario) && administrador.getPassword().equals(password)) {
                administradoresLogueados.add(administrador);
                return administrador;
            }
        }
        return null;
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
