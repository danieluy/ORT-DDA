package logica;

import java.util.ArrayList;

class SistemaUsuarios {

    ArrayList<Usuario> usuarios;
    ArrayList<Jugador> jugadores;
    ArrayList<Jugador> jugadoresLogueados;
    ArrayList<Administrador> administradores;
    ArrayList<Administrador> administradoresLogueados;

    public Jugador loginJugador(String usuario, String password) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(usuario) && jugador.getPassword().equals(password)) {
                jugadoresLogueados.add(jugador);
                return jugador;
            }
        }
        return null;
    }

    public Administrador loginAdministrador(String password, String pass) {
        for (Administrador administrador : administradores) {
            if (administrador.getNombre().equals(password) && administrador.getPassword().equals(pass)) {
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

}
