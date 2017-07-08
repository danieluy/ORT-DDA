package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.ApuestaException;
import modelo.Casillero;
import modelo.CasilleroException;
import modelo.Modelo;
import modelo.Jugador;
import modelo.JugadorException;
import modelo.Partida;
import modelo.PartidaException;
import vista.CasilleroPanel;

public class PartidaControlador implements Observer {

  private Modelo modelo = Modelo.getInstancia();
  private PartidaVista vista;
  private Partida partida;
  private Jugador jugador;
  private boolean tableroIniciado = false;

  public PartidaControlador(PartidaVista vista) {
    this.vista = vista;
  }

  public void crearPartida(Jugador jugador) {
    try {
      this.jugador = jugador;
      this.jugador.puedeJugar();
      partida = modelo.crearPartida(jugador);
      partida.addObserver(this);
      // Si es el jugador 1 preguntamos tamaño de tablero
      // Si es el jugador 2 espera
      if (partida.getJugador2() == jugador)
        if (partida.iniciada())
          iniciarTablero();
        else
          vista.mostrarEspera("Esperando por " + partida.getJugador1().getNombreCompleto());
      vista.setTitulo(tituloPartida());
    }
    catch (PartidaException | ApuestaException | JugadorException ex) {
      vista.mostrarEspera(ex.getMessage());
    }
  }

  public void setTamanoTablero(String str_tamano) {
    try {
      partida.setTamanoTablero(Integer.parseInt(str_tamano));
    }
    catch (PartidaException | ApuestaException ex) {
      vista.mostrarError(ex.getMessage());
    }
    catch (NumberFormatException ex) {
      vista.mostrarError("El tamaño del tablero debe ser un número entero (mín = " + Partida.TAMANO_MINIMO + ", máx = " + Partida.TAMANO_MAXIMO);
    }
  }

  public void destapar(int i) {
    Casillero c = partida.getCasilleros().get(i);
    System.out.println(c);
    destapar(c);
  }

  public void destapar(CasilleroPanel casillero) {
    try {
      partida.destaparCasillero(casillero, jugador);
    }
    catch (PartidaException | CasilleroException | ApuestaException ex) {
      vista.mostrarError(ex.getMessage());
    }
  }

  private String getNombreTurno() {
    if (partida.esTurnoDe(jugador))
      return "Juegas tu";
    return "Juega tu oponente";
  }

  private String tituloPartida() {
    String titulo;
    if (partida.iniciada())
      titulo = partida.getJugador1().getNombreCompleto() + " vs. " + partida.getJugador2().getNombreCompleto();
    else if (partida.terminada())
      titulo = "Partida finalizada";
    else
      titulo = partida.getJugador1().getNombreCompleto() + " esperando oponente";
    return titulo;
  }

  private void iniciarTablero() {
    vista.iniciarTablero();
    tableroIniciado = true;
    actualizarPartida();
  }

  private void actualizarPartida() {
    if (tableroIniciado) {
      vista.mostrarTablero(partida.getTamano(), partida.getCasilleros());
      vista.mostrarDatos(tituloPartida(), getNombreTurno(), jugador.getSaldo(), partida.getPozo(), partida.getApuesta().getTotalApostado(), partida.getNumeroTurno(), partida.getTiempoTurno());
    }
  }

  public void salir() {
    if (partida != null) {
      partida.deleteObserver(this);
      partida.salir(jugador);
    }
    modelo.logoutJugador(jugador);
  }

  public void apostar(String str_monto) {
    try {
      partida.apostar(jugador, Double.parseDouble(str_monto));
    }
    catch (ApuestaException ex) {
      vista.mostrarError(ex.getMessage());
    }
    catch (NumberFormatException ex) {
      vista.mostrarError("El monto apostado debe ser un número");
    }
  }

  public void pagar() {
    try {
      partida.pagarApuesta(jugador);
    }
    catch (ApuestaException ex) {
      vista.mostrarError(ex.getMessage());
    }
  }

  public void subir(String str_monto) {
    try {
      partida.subirApuesta(jugador, Integer.parseInt(str_monto));
    }
    catch (ApuestaException ex) {
      vista.mostrarError(ex.getMessage());
    }
    catch (NumberFormatException ex) {
      vista.mostrarError("El monto apostado debe ser un número");
    }
  }

  private String getInfoFinPartida() {
    if (partida.getGanador() == null)
      return "Aún no hay ganador";
    if (partida.getGanador() == jugador)
      return "Has ganado la partida!";
    return "Has perdido";
  }

  private void quitarJugador2() {
    partida.quitarJugador2();
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento == Partida.Eventos.partidaLlena)
      vista.setTitulo(tituloPartida());
    if (evento == Partida.Eventos.tableroCreado)
      vista.mostrarEspera("Esperando oponente");
    if (evento == Partida.Eventos.partidaIniciada)
      iniciarTablero();
    if (evento == Partida.Eventos.apuesta || evento == Partida.Eventos.movimientoEfectuado)
      actualizarPartida();
    if (evento == Partida.Eventos.partidaTerminada) {
      actualizarPartida();
      vista.mostarMensaje(getInfoFinPartida());
    }
    if (evento == Partida.Eventos.jugadorSeHaRendido) {
      actualizarPartida();
      vista.mostarMensaje("Has ganado la partida!");
    }
    if (evento == Partida.Eventos.jugador2NoJuega)
      quitarJugador2();
    if (evento == Partida.Eventos.tiempo) // por razones de performance en este caso solo actualizo la vista de datos
      vista.mostrarTiempo(partida.getTiempoTurno());
      if (evento == Partida.Eventos.partidaCancelada) {
        vista.mostrarError(partida.getJugador1().getNombreCompleto() + " ha cancelado la partida");
        vista.cerrar();
      }
  }
}
