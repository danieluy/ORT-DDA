package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Color;
import java.util.Observer;
import vista.CasilleroPanel;

public class Partida extends Observable implements Observer {

  public static final int TAMANO_MINIMO = 3;
  public static final int TAMANO_MAXIMO = 10;
  public static final int TIEMPO_TURNO = 15; // agregar a diagrama !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  public static final double APUESTA_INICIAL = 10;
  private final Color COLOR_1 = Color.CYAN;
  private final Color COLOR_2 = Color.YELLOW;
  private double pozo = 0;
  private int tamano = 0;
  private Jugador ganador;
  private Apuesta apuesta;
  private Jugador jugador1;
  private Jugador jugador2;
  private ArrayList<Casillero> casilleros = new ArrayList();
  private ArrayList<Movimiento> movimientos = new ArrayList();
  private Temporizador temporizador;

  public Partida(Jugador jugador) throws PartidaException {
    jugador1 = jugador;
    jugador1.setColor(COLOR_1);
    jugador1.setPartida(this);
  }

  public enum Eventos {
    partidaLlena,
    tableroCreado,
    partidaIniciada,
    jugadorSeHaRendido,
    partidaTerminada,
    apuesta,
    movimientoEfectuado,
    partidaCancelada,
    jugador2NoJuega,
    tiempo
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  public void setJugador2(Jugador jugador) throws ApuestaException {
    jugador2 = jugador;
    jugador2.setColor(COLOR_2);
    jugador2.setPartida(this);
    notificar(Eventos.partidaLlena);
    iniciarPartida();
  }

  public void quitarJugador2() {
    jugador2.abandonarPartida();
    jugador2 = null;
  }

  public void setTamanoTablero(int tamano) throws PartidaException, ApuestaException {
    if (tamano < TAMANO_MINIMO)
      throw new PartidaException("El tamaño mínimo del tablero es de " + TAMANO_MINIMO + (TAMANO_MINIMO == 1 ? " casillero" : " casilleros"));
    if (tamano > TAMANO_MAXIMO)
      throw new PartidaException("El tamaño máximo del tablero es de " + TAMANO_MAXIMO + " casilleros");
    this.tamano = tamano;
    for (int i = 0; i < (tamano * tamano); i++)
      casilleros.add(new Casillero());
    plantarMina();
    notificar(Eventos.tableroCreado);
    iniciarPartida();
  }

  private void iniciarPartida() throws ApuestaException {
    if (haIniciado()) {
      iniciarApuestas();
      addMovimiento();
      notificar(Eventos.partidaIniciada);
      temporizador = new Temporizador(TIEMPO_TURNO, this);
    }
  }

  public void salir(Jugador jugador) {
    if (haIniciado() && !haTerminado()) {
      ganador = getOponente(jugador);
      ganador.setSaldo(ganador.getSaldo() + pozo);
      notificar(Eventos.jugadorSeHaRendido);
    }
    else if (!haIniciado() && jugador == jugador1)
      notificar(Eventos.partidaCancelada);
    else if (!haIniciado() && jugador == jugador2)
      notificar(Eventos.jugador2NoJuega);
  }

  protected void continuar() {
    addMovimiento();
    plantarMina();
    temporizador = new Temporizador(TIEMPO_TURNO, this);
  }

  protected void terminar() {
    destaparMinas();
    terminarPartida();
  }

  public void terminarPartida() {
    if (haIniciado() && !haTerminado()) {
      if (esTurnoDe(jugador1))
        ganador = jugador2;
      else
        ganador = jugador1;
      ganador.setSaldo(ganador.getSaldo() + pozo);
      notificar(Eventos.partidaTerminada);
      temporizador.detener();
    }
  }

  public void destaparCasillero(CasilleroPanel casilleroPanel, Jugador jugador)
      throws PartidaException, CasilleroException, ApuestaException {
    if (haIniciado()) {
      if (!esTurnoDe(jugador))
        throw new PartidaException("No es tu turno");
      if (!apuesta.estaPaga())
        throw new ApuestaException("Apuesta en curso");
      temporizador.detener();
      Casillero casillero = (Casillero) casilleroPanel;
      casillero.validarDestapar(jugador);
      casillero.destapar(this);
    }
  }

  private void iniciarApuestas() throws ApuestaException {
    apostar(jugador1, APUESTA_INICIAL);
    pagarApuesta(jugador2);
  }

  public void apostar(Jugador jugadorApuesta, double monto) throws ApuestaException {
    if (haIniciado()) {
      apuesta = new Apuesta(jugadorApuesta, getOponente(jugadorApuesta), monto);
      pozo += monto;
      notificar(Eventos.apuesta);
    }
  }

  public void pagarApuesta(Jugador jugadorPaga) throws ApuestaException {
    if (haIniciado() && !apuesta.estaPaga()) {
      apuesta.pagar(jugadorPaga);
      pozo += apuesta.getApostado();
      notificar(Eventos.apuesta);
    }
  }

  public void subirApuesta(Jugador jugador, double monto) throws ApuestaException {
    if (haIniciado() && !apuesta.estaPaga()) {
      apuesta.subir(jugador, monto);
      pozo += (apuesta.getApostado() + monto);
      notificar(Eventos.apuesta);
    }
  }

  protected Jugador getOponente(Jugador jugador) {
    if (jugador == jugador1)
      return jugador2;
    else
      return jugador1;
  }

  private void plantarMina() {
    if (esTurnoDe(jugador1) || movimientos.size() == 0) {
      boolean minaColocada = false;
      while (!minaColocada) {
        int indice = (int) Math.round(Math.random() * ((tamano * tamano) - 1));
        Casillero casillero = casilleros.get(indice);
        casillero.agregarMina(this);
        minaColocada = casillero.tieneMina();
      }
    }
//        contadorMinas();
  }
//  private void contadorMinas() {//  Solo para desarrollo, no aparece en diagrama
//    int minas = 0;
//    for (Casillero casillero : casilleros)
//      if (casillero.tieneMina())
//        minas++;
//    System.out.println("Minas: " + minas);
//  }

  public boolean tableroCreado() {
    return tamano >= TAMANO_MINIMO;
  }

  protected void destaparMinas() { // revisar estooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    // minas de la partida
    for (Casillero c : casilleros)
      c.activarMina();
    // minas del estado del movimiento
    movimientos.get(movimientos.size() - 1).destaparMinas();
  }

  protected void addMovimiento() {
    Jugador jugador = esTurnoDe(jugador1) ? jugador1 : jugador2;
    movimientos.add(new Movimiento(casilleros, jugador, pozo, this.getNumeroTurno()));
    notificar(Eventos.movimientoEfectuado);
  }

  public boolean esTurnoDe(Jugador jugador) {
    if (movimientos.size() <= 1)// el primer movimiento son todos los casillero tapados
      return jugador == jugador1;
    return jugador != movimientos.get(movimientos.size() - 1).getJugador();
  }

  public boolean haIniciado() {
    return (jugador2 != null && tamano >= TAMANO_MINIMO);
  }

  public boolean haTerminado() {
    return ganador != null;
  }

//    Getters & Setters
  public int getCasillerosRestantes() {
    int casillerosDestapados = movimientos.size() - 1 < 0 ? 0 : movimientos.size() - 1;
    return (tamano * tamano) - casillerosDestapados;
  }

  public int getTamano() {
    return tamano;
  }

  public ArrayList<Casillero> getCasilleros() {
    return casilleros;
  }

  public double getPozo() {
    return pozo;
  }

  public int getNumeroTurno() {
    int cantMov = movimientos.size();
    return cantMov < 2 ? 0 : (cantMov - (cantMov % 2)) / 2;
  }

  public Jugador getJugador1() {
    return jugador1;
  }

  public Jugador getJugador2() {
    return jugador2;
  }

  public Apuesta getApuesta() {
    return apuesta;
  }

  public ArrayList<Movimiento> getMovimientos() {
    return movimientos;
  }

  public Jugador getGanador() {
    if (haTerminado())
      return ganador;
    return null;
  }

  public Jugador getJugadorTurno() {
    if (esTurnoDe(jugador1))
      return jugador1;
    return jugador2;
  }

  public int getTiempoTurno() {
    if (temporizador != null)
      return temporizador.getTiempo();
    return 0;
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento == Temporizador.Eventos.tiempo)
//      notificar(Eventos.tiempo);
      if (evento == Temporizador.Eventos.tiempo_agotado)
        terminar();
    if (evento == Temporizador.Eventos.interrupted_exception)
      System.out.println("Error de temporizador");
  }
}
