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

  PartidaControlador controlador;
  private AsyncContext contexto;
  private PrintWriter out;

  public void inicializar(Jugador jugador, AsyncContext contexto) {
    this.contexto = contexto;
    try {
      this.out = this.contexto.getResponse().getWriter();
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    controlador = new PartidaControlador(this);
    controlador.crearPartida(jugador);
  }

  public void enviar(String evento, String dato) {

    out.write("event: " + evento + "\n");
    dato = dato.replace("\n", "");
    out.write("data: " + dato + "\n\n");
    if (out.checkError()) {//checkError llama a flush, si da false evío bien
      cerrar();
    }
    else {
      //TODO OK!
      // System.out.println("Enviado");
    }
  }

  public void setTamanoTablero(String tamano) {
    controlador.setTamanoTablero(tamano);
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
//    enviar("iniciarTablero", null);
    return;
  }

  @Override
  public void mostrarTablero(int tamano, ArrayList casilleros) {
    String jsonString = "[";
    for (Object o : casilleros) {
      Casillero c = (Casillero) o;
      String casilleroString = "{\"color\": "
          + "\"" + c.getColorRGB()+ "\""
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void mostarMensaje(String string) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void cerrar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
