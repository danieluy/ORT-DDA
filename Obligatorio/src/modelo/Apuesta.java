package modelo;

public class Apuesta {

    private Jugador jugador;
    private double apostado;
    private double totalApostado;
    private boolean estaPaga = false;

    public Apuesta(Jugador jugadorApuesta, Jugador jugadorPaga, double monto) throws ApuestaException {
        if (!jugadorApuesta.puedeApostar(monto) || !jugadorPaga.puedeApostar(monto)) {
            double apuestaMaxima = jugadorApuesta.getSaldo() < jugadorPaga.getSaldo() ? jugadorApuesta.getSaldo() : jugadorPaga.getSaldo();
            throw new ApuestaException("La apuesta máxima en este punto es de $" + apuestaMaxima);
        }
        jugador = jugadorApuesta;
        apostado = monto;
        totalApostado = monto;
        jugador.setSaldo(jugador.getSaldo() - monto);
    }

    public void pagar(Jugador jugadorPaga) throws ApuestaException {
        if (jugadorPaga == this.jugador) {
            throw new ApuestaException("El jugador " + jugadorPaga.getNombre() + " no puede pagar su apuesta");
        }
        if (!jugadorPaga.puedeApostar(apostado)) {
            throw new ApuestaException("Saldo insuficiente");
        }
        totalApostado += apostado;
        jugadorPaga.setSaldo(jugadorPaga.getSaldo() - apostado);
        estaPaga = true;
    }

    public void subir(Jugador jugadorAumenta, double aumento) throws ApuestaException {
        if (jugadorAumenta == this.jugador) {
            throw new ApuestaException("El jugador " + jugadorAumenta.getNombre() + " no puede aumentar su apuesta");
        }
        if (!jugadorAumenta.puedeApostar(apostado + aumento)) {
            throw new ApuestaException("Saldo insuficiente");
        }
        jugador = jugadorAumenta;
        double nuevaApuesta = apostado + aumento;
        apostado = aumento;
        totalApostado += nuevaApuesta;
        jugadorAumenta.setSaldo(jugadorAumenta.getSaldo() - nuevaApuesta);
    }

//    Getters & Setters
    public Jugador getJugador() {
        return jugador;
    }

    public boolean estaPaga() {
        return estaPaga;
    }

    public double getTotalApostado() {
        if (!estaPaga) {
            return totalApostado;
        }
        return 0;
    }

    public double getApostado() {
        return apostado;
    }
}
