package servlets;

import VistasWeb.PartidaWeb;
import java.io.IOException;
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
    HttpSession sesion = request.getSession(false);
    if (sesion == null)
      return;
    Jugador jugador = (Jugador) sesion.getAttribute("jugador");
    if (jugador == null)
      return;
    String accion = request.getParameter("accion");
    if (accion != null && accion.equals("new")) {
//      Setup SSE
      request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
      AsyncContext contexto = request.startAsync();
      contexto.getResponse().setContentType("text/event-stream");
      contexto.getResponse().setCharacterEncoding("UTF-8");
      contexto.setTimeout(0);//No timeout
//      Inicializar la Vista
      PartidaWeb vista = new PartidaWeb();
      vista.inicializar(jugador, contexto);
      sesion.setAttribute("vista", vista);
    }
    else {
      PartidaWeb vista = (PartidaWeb) sesion.getAttribute("vista");
      if (vista == null)
        return;
      
      String tamano = request.getParameter("tamano");
      if (tamano != null)
        vista.setTamanoTablero(tamano);
      
      String apostar = request.getParameter("apostar");
      if (apostar != null)
        vista.apostar(apostar);
      
      String subir = request.getParameter("subir");
      if (subir != null)
        vista.subir(subir);
      
      String pagar = request.getParameter("pagar");
      if (pagar != null)
        vista.pagar();
      
      String destapar = request.getParameter("destapar");
      if (destapar != null)
        vista.destapar(destapar);
      
      String salir = request.getParameter("salir");
      if (salir != null)
        vista.salir();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
