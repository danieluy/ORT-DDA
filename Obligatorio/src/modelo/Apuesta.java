package modelo;

public class Apuesta {

    private Jugador jugador;
    private double monto;
    private boolean paga = false;

    public Apuesta(Jugador jugadorApuesta, Jugador jugadorPaga, double monto) throws PartidaException {
        if (!jugadorApuesta.puedeApostar(monto) && jugadorPaga.puedeApostar(monto)) {
            double apuestaMaxima = jugadorApuesta.getSaldo() < jugadorPaga.getSaldo() ? jugadorApuesta.getSaldo() : jugadorPaga.getSaldo();
            throw new PartidaException("La apuesta máxima en este punto es de $" + apuestaMaxima);
        }
        this.jugador = jugadorApuesta;
        this.monto = monto;
        jugador.setSaldo(jugador.getSaldo() - monto);
    }

    public void pagarApuesta(Jugador jugador) throws PartidaException {
        if (jugador == this.jugador) {
            throw new PartidaException("El jugador " + jugador.getNombre() + " no puede pagar su apuesta");
        }
        if (!jugador.puedeApostar(monto)) {
            throw new PartidaException("Saldo insuficiente");
        }
        jugador.setSaldo(jugador.getSaldo() - monto);
        paga = true;
    }

//    Getters & Setters
    public Jugador getJugador() {
        return jugador;
    }

    public boolean isPaga() {
        return paga;
    }

}
