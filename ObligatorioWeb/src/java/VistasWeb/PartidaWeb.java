package VistasWeb;

import controlador.PartidaControlador;
import controlador.PartidaVista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.AsyncContext;
import modelo.Casillero;
import modelo.Jugador;

public class PartidaWeb implements PartidaVista {

  private PartidaControlador controlador;
  private AsyncContext contexto;
  private PrintWriter writer;

  public void inicializar(Jugador jugador, AsyncContext contexto) {
    this.contexto = contexto;
    try {
      this.writer = this.contexto.getResponse().getWriter();
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    controlador = new PartidaControlador(this);
    controlador.crearPartida(jugador);
  }

  public void enviar(String evento, String dato) {
    writer.write("event: " + evento + "\n");
    dato = dato.replace("\n", "");
    writer.write("data: " + dato + "\n\n");
    if (writer.checkError()) {//checkError llama a flush, si da false evío bien
      cerrar();// El problema con esto es que cuendo ocurre un error el jugador pierde la partida
    }
    else {
      // TODO OK!
      // System.out.println("Enviado");
    }
  }

  // Delegación de métodos del controlador
  public void setTamanoTablero(String tamano) {
    controlador.setTamanoTablero(tamano);
  }

  public void apostar(String monto) {
    controlador.apostar(monto);
  }

  public void pagar() {
    controlador.pagar();
  }

  public void subir(String monto) {
    controlador.subir(monto);
  }

  public void destapar(String i) {
    try {
      controlador.destapar(Integer.parseInt(i));
    }
    catch (Exception ex) {
      mostrarError("Error al destapar el casillero " + i);
    }
  }

  public void salir() {
    controlador.salir();
  }

  @Override
  public void setTitulo(String titulo) {
    enviar("setTitulo", titulo);
  }

  @Override
  public void mostrarError(String mensaje) {
    enviar("mostrarError", mensaje);
  }

  @Override
  public void iniciarTablero() {
    // No es necesario
  }

  @Override
  public void mostrarTablero(int tamano, ArrayList casilleros) {
    String jsonString = "[";
    for (Object o : casilleros) {
      Casillero c = (Casillero) o;
      String casilleroString = "{\"color\": "
          + "\"" + c.getColorRGB() + "\""
          + ", \"mina\": "
          + (c.getTipoMina() == null ? c.getTipoMina() : ("\"" + c.getTipoMina() + "\""))
          + "},";
      jsonString += casilleroString;
    }
    jsonString = jsonString.substring(0, jsonString.length() - 1) + "]";
    System.out.println("jsonString " + jsonString);
    enviar("mostrarTablero", jsonString);
  }

  @Override
  public void mostrarEspera(String mensaje) {
    enviar("mostrarEspera", mensaje);
  }

  @Override
  public void mostrarDatos(String tituloPartida, String turno, double saldo, double pozo, double apuestaActual, int numeroTurno, int tiempoTurno) {
    String datos = "{"
        + "\"tituloPartida\":" + "\"" + tituloPartida + "\","
        + "\"turno\":" + "\"" + turno + "\","
        + "\"saldo\":" + "\"$" + saldo + "\","
        + "\"pozo\":" + "\"$" + pozo + "\","
        + "\"apuestaActual\":" + "\"$" + apuestaActual + "\","
        + "\"numeroTurno\":" + "\"#" + numeroTurno + "\","
        + "\"tiempoTurno\":" + "\"" + tiempoTurno + " seg.\""
        + "}";
    enviar("mostrarDatos", datos);
  }

  @Override
  public void mostarMensaje(String mensaje) {
    enviar("mostarMensaje", mensaje);
  }

  @Override
  public void cerrar() {
    // No es necesario
  }

  @Override
  public void mostrarTiempo(int tiempoTurno) {
    enviar("tiempo", tiempoTurno + " seg.");
  }

}
