package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Color;
import java.util.Observer;
import vista.CasilleroPanel;

public class Partida extends Observable implements Observer {

  public static final int TAMANO_MINIMO = 3;
  public static final int TAMANO_MAXIMO = 10;
  public static final int TIEMPO_TURNO = 100;
  public static final double APUESTA_INICIAL = 10;
  private int oid;
  private final Color COLOR_1 = Color.CYAN;
  private final Color COLOR_2 = Color.YELLOW;
  private double pozo = 0;
  private int tamano = 0;
  private Jugador ganador;
  private Apuesta apuesta;
  private Jugador turno;
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

  public Partida() {
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
    tiempo,
    partidaActualizada
  }

  private void notificar(Object evento) {
    setChanged();
    notifyObservers(evento);
  }
  
  public void restaurarDesdeBD(int tamano, int oidGanador, int oidJugador1, int oidJugador2){
    this.tamano = tamano;
    this.ganador = Modelo.getInstancia().getJugadorByOid(oidGanador);
    this.jugador1 = Modelo.getInstancia().getJugadorByOid(oidJugador1);
    this.jugador1.setColor(COLOR_1);
    this.jugador2 = Modelo.getInstancia().getJugadorByOid(oidJugador2);
    this.jugador2.setColor(COLOR_2);
  }
  
  public void addMovimientoDesdeBD(Movimiento movimiento){
    this.movimientos.add(movimiento);
  }

  public void setJugador2(Jugador jugador) throws ApuestaException {
    jugador2 = jugador;
    jugador2.setColor(COLOR_2);
    jugador2.setPartida(this);
    notificar(Eventos.partidaLlena);
    iniciar();
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
    if (this.tamano >= TAMANO_MINIMO)
      throw new PartidaException("Tablero ya iniciado");
    this.tamano = tamano;
    for (int i = 0; i < cantCasilleros(); i++)
      casilleros.add(new Casillero());
    plantarMina();
    notificar(Eventos.tableroCreado);
    iniciar();
  }

  private void iniciar() throws ApuestaException {
    if (iniciada()) { // necesario porque deben cumplirse dos condiciones no simultáneas para poder iniciar
      iniciarApuestas();
      registrarMovimiento();
      turno = jugador1;
      notificar(Eventos.partidaIniciada);
      temporizador = new Temporizador(TIEMPO_TURNO, this);
    }
  }

  protected void continuar() {
    if (iniciada() && !terminada()) {
      // Cambios de estado
      plantarMina();
      temporizador = new Temporizador(TIEMPO_TURNO, this);
      cambiarTurno();
      // Registrar cambios de estado
      registrarMovimiento();
      // Notificar cambios de estado
      notificar(Eventos.partidaActualizada);
    }
  }

  public void terminar() {
    if (iniciada() && !terminada()) {
      // Cambios de estado
      temporizador.detener();
      destaparMinas();
      ganador = getOponente(turno);
      ganador.setSaldo(ganador.getSaldo() + pozo);
      // Registrar cambios de estado
      registrarMovimiento();
      // Notificar cambios de estado
      notificar(Eventos.partidaTerminada);
    }
  }

  public void salir(Jugador jugador) {
    if (iniciada() && !terminada()) {
      turno = jugador;
      terminar();
    }
    else if (!iniciada() && jugador == jugador1)
      notificar(Eventos.partidaCancelada);
    else if (!iniciada() && jugador == jugador2)
      notificar(Eventos.jugador2NoJuega);
  }

  private void cambiarTurno() {
    turno = getOponente(turno);
  }

  public void destaparCasillero(CasilleroPanel casilleroPanel, Jugador jugador)
      throws PartidaException, CasilleroException, ApuestaException {
    if (iniciada()) {
      if (!esTurnoDe(jugador))
        throw new PartidaException("No es tu turno");
      if (!apuesta.estaPaga())
        throw new ApuestaException("Apuesta en curso");
      temporizador.detener();
      Casillero casillero = (Casillero) casilleroPanel;
      casillero.destapar(this);
    }
  }

  private void iniciarApuestas() throws ApuestaException {
    apostar(jugador1, APUESTA_INICIAL);
    pagarApuesta(jugador2);
  }

  public void apostar(Jugador jugadorApuesta, double monto) throws ApuestaException {
    if (iniciada()) {
      apuesta = new Apuesta(jugadorApuesta, getOponente(jugadorApuesta), monto);
      pozo += monto;
      notificar(Eventos.apuesta);
    }
  }

  public void pagarApuesta(Jugador jugadorPaga) throws ApuestaException {
    if (iniciada() && !apuesta.estaPaga()) {
      apuesta.pagar(jugadorPaga);
      pozo += apuesta.getApostado();
      notificar(Eventos.apuesta);
    }
  }

  public void subirApuesta(Jugador jugador, double monto) throws ApuestaException {
    if (iniciada() && !apuesta.estaPaga()) {
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
    if (esTurnoDe(jugador2) || cantCasillerosDestapados() == 0) {
      boolean minaColocada = false;
      for (int i = 0; i < cantCasilleros() && !minaColocada; i++) {
        int random = Auxiliar.random(cantCasilleros() - 1);
        Casillero casillero = casilleros.get(random);
        minaColocada = casillero.agregarMina(this);
      }
    }
  }

  public boolean tableroCreado() {
    return tamano >= TAMANO_MINIMO;
  }

  protected void destaparMinas() {
    for (Casillero c : casilleros)
      c.activarMina();
  }

  protected void registrarMovimiento() {
    movimientos.add(new Movimiento(casilleros, getJugadorTurno(), pozo, this.getNumeroTurno()));
    notificar(Eventos.movimientoEfectuado);
  }

  public boolean esTurnoDe(Jugador jugador) {
    if (turno == null)
      return jugador == jugador1;
    return jugador == turno;
  }

  public boolean iniciada() {
    return (jugador2 != null && tamano >= TAMANO_MINIMO);
  }

  public boolean terminada() {
    return ganador != null;
  }

//    Getters & Setters
  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  private int cantCasilleros() {
    return tamano * tamano;
  }

  private int cantCasillerosDestapados() {
    // -1 porque el primero movimiento son todos los casileros tapados
    return movimientos.size() - 1 < 0 ? 0 : movimientos.size() - 1;
  }

  public int cantCasillerosTapados() {
    return cantCasilleros() - cantCasillerosDestapados();
  }

  public int cantMinasColocadas() {
    int minasColocadas = 0;
    for (Casillero c : casilleros) {
      if (c.tieneMina())
        minasColocadas++;
    }
    return minasColocadas;
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
    if (terminada())
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
      notificar(Eventos.tiempo);
    if (evento == Temporizador.Eventos.tiempo_agotado)
      terminar();
    if (evento == Temporizador.Eventos.interrupted_exception)
      System.out.println("Error de temporizador");
  }
}
