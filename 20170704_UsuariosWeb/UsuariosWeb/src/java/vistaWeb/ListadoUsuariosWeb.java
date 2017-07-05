package vistaWeb;

import controlador.ControladorListado;
import controlador.VistaListado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import modelo.Usuario;
import utilidades.Componentes;

//La "vista web" no puede ser el servlet, por especificacion Tomcat solo crea UNA instancia por servlet,
//por lo que no puede haber estado en el servlet.
public class ListadoUsuariosWeb implements VistaListado, HttpSessionBindingListener {

  private ControladorListado controlador;
  private AsyncContext contexto;
  private PrintWriter out;

  public ListadoUsuariosWeb() {
  }

  public void iniciar(AsyncContext contexto, Usuario usuario) throws IOException {

    this.contexto = contexto;
    out = contexto.getResponse().getWriter();
    controlador = new ControladorListado(this, usuario);

  }

  public void enviar(String evento, String dato) {

    out.write("event: " + evento + "\n");
    dato = dato.replace("\n", "");
    out.write("data: " + dato + "\n\n");
    if (out.checkError()) {//checkError llama a flush, si da false evio bien
      cerrar();
    }
    else {
      //TODO OK!
      // System.out.println("Enviado");
    }
  }

  @Override
  public void mostrar(ArrayList<Usuario> usuarios) {
    String lista = "No hay usuarios conectados";
    if (usuarios.size() > 0) {
      lista = Componentes.lista(true, "lstUsuarios", usuarios);
    }
    enviar("usuarios", lista);
  }

  @Override
  public void mostrar(Usuario actual) {
    String strUsr = "No hay usuario logueado";
    if (actual != null)
      strUsr = actual.getNombreCompleto();
    enviar("usuario", strUsr);
  }

  //Si la vista sale de la sesion se cierra y hace logout
  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    logout();
    cerrar();
  }

  private void cerrar() {
    controlador.salir();
    try {
      contexto.complete(); //finalizo el contexto asincronico
    }
    catch (Exception e) {
    }
  }

  @Override
  public void valueBound(HttpSessionBindingEvent event) {

  }

  public void logout() {
    controlador.logout();
  }

}
