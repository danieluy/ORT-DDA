package servlets;

import VistasWeb.PartidaWeb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Jugador;

@WebServlet(name = "PartidaServlet", urlPatterns = {"/partida"})
public class PartidaServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String accion = request.getParameter("accion");
    if (accion == null)
      return;
    HttpSession sesion = request.getSession(false);
    if (sesion == null)
      return;
    Jugador jugador = (Jugador) sesion.getAttribute("jugador");
    if (jugador == null)
      return;
    if (accion.equals("new")) {
//      Setup SSE
      request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
      AsyncContext contexto = request.startAsync();
      contexto.getResponse().setContentType("text/event-stream");
      contexto.getResponse().setCharacterEncoding("UTF-8");
      contexto.setTimeout(0);//No timeout
//      Inicializar la Vista
      PartidaWeb vista = new PartidaWeb();
      vista.inicializar(jugador, contexto);
      sesion.setAttribute("vistaPartida", vista);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession sesion = request.getSession(false);
    if (sesion == null)
      return;
    Jugador jugador = (Jugador) sesion.getAttribute("jugador");
    if (jugador == null)
      return;
    PartidaWeb vista = (PartidaWeb) sesion.getAttribute("vistaPartida");
    if (vista == null)
      return;
    
    String tamano = request.getParameter("tamano");
    if (tamano != null)
      vista.setTamanoTablero(tamano);
    
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
