package modelo;

import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();

    public Jugador loginJugador(String usuario, String password) throws UsuarioException {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(usuario) && jugador.getPassword().equals(password)) {
                jugadorEstaLogueado(jugador);
                return jugador;
            }
        }
        throw new UsuarioException("Usuario y/o contraseña incorrectos");
    }

    public Administrador loginAdministrador(String usuario, String password) throws UsuarioException {
        for (Administrador administrador : administradores) {
            if (administrador.getNombre().equalsIgnoreCase(usuario) && administrador.getPassword().equals(password)) {
                return administrador;
            }
        }
        throw new UsuarioException("Usuario y/o contraseña incorrectos");
    }

    private void jugadorEstaLogueado(Jugador jugador) throws UsuarioException {
        if (jugador.tienePartida()) {
            throw new UsuarioException("El jugador " + jugador.getNombre() + " ya se encuantra en el sistema");
        }
    }

    public void logoutJugador(Jugador jugador) {
        jugador.abandonarPartida();
    }

    public void logoutAdministrador(Administrador administrador) {
        // esperando para tomar una acción relevante
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
