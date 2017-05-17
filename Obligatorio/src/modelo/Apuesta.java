package modelo;

public class Apuesta {

    private Jugador jugador;
    private double monto;
    private boolean estaPaga = false;

    public Apuesta(Jugador jugadorApuesta, Jugador jugadorPaga, double monto) throws ApuestaException {
        if (!jugadorApuesta.puedeApostar(monto) || !jugadorPaga.puedeApostar(monto)) {
            double apuestaMaxima = jugadorApuesta.getSaldo() < jugadorPaga.getSaldo() ? jugadorApuesta.getSaldo() : jugadorPaga.getSaldo();
            throw new ApuestaException("La apuesta máxima en este punto es de $" + apuestaMaxima);
        }
        jugador = jugadorApuesta;
        this.monto = monto;
        jugador.setSaldo(jugador.getSaldo() - monto);
    }

    public void pagar(Jugador jugador) throws ApuestaException {
        if (jugador == this.jugador) {
            throw new ApuestaException("El jugador " + jugador.getNombre() + " no puede pagar su apuesta");
        }
        if (!jugador.puedeApostar(monto)) {
            throw new ApuestaException("Saldo insuficiente");
        }
        jugador.setSaldo(jugador.getSaldo() - monto);
        estaPaga = true;
    }

    public void subir(Jugador jugador, int monto) throws ApuestaException {
        if (jugador == this.jugador) {
            throw new ApuestaException("El jugador " + jugador.getNombre() + " no puede aumentar su apuesta");
        }
        if (!jugador.puedeApostar(monto)) {
            throw new ApuestaException("Saldo insuficiente");
        }
        jugador.setSaldo(jugador.getSaldo() - monto);
        this.jugador = jugador;
        this.monto += monto;
    }

//    Getters & Setters
    public Jugador getJugador() {
        return jugador;
    }

    public boolean estaPaga() {
        return estaPaga;
    }

    public double getMontoActual() {
        if (!estaPaga) {
            return monto;
        }
        return 0;
    }

    public double getMonto() {
        return monto;
    }
}
