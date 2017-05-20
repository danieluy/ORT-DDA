package modelo;

import java.util.ArrayList;

public class SistemaPartidas {

    private ArrayList<Partida> partidas = new ArrayList();

    public Partida crearPartida(Jugador jugador) throws PartidaException, ApuestaException {
        if (jugador.puedeApostar(Partida.APUESTA_INICIAL)) {
            // si no existen partidas creo la primera
            if (partidas.size() > 0) {
                // si la ultima partida no está llena la completo, si está llena creo una nueva
                Partida ultimaPartida = partidas.get(partidas.size() - 1);
                if (ultimaPartida.getJugador2() == null) {
                    ultimaPartida.setJugador2(jugador);
                }
                else {
                    partidas.add(new Partida(jugador));
                }
            }
            else {
                partidas.add(new Partida(jugador));
            }
            return partidas.get(partidas.size() - 1);
        }
        throw new PartidaException("Para jugar es necesario un saldo mínimo de $" + Partida.APUESTA_INICIAL);
    }

    public void validarCerrarInicio() throws PartidaException {
        for (Partida partida : partidas) {
            if (!partida.haTerminado()) {
                throw new PartidaException("Hay juegos activos");
            }
        }
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

}
