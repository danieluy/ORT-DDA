/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.LoginControlador;
import controlador.LoginVista;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import modelo.Jugador;
import modelo.Usuario;

@WebServlet(name = "LoginJugador", urlPatterns = {"/loginjugador"})
public class LoginJugador extends HttpServlet implements LoginVista {

  LoginControlador controlador = new LoginControlador(this);
  HttpServletResponse response;

  public LoginJugador() {
    try {
      vista.Main.main(null);
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.response = response;
    String nombre = request.getParameter("nombre");
    String password = request.getParameter("password");
    System.out.println(nombre + " - " + password);
    controlador.login(nombre, password, Usuario.TiposUsuario.jugador);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
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

  @Override
  public void loginJugadorOk(Jugador jugador) {
    // inicio partida
//    new PartidaFrame(jugador).setVisible(true);
    try {
      response.sendRedirect("index.jsp?mensaje=Bienvenid@ " + jugador.getNombreCompleto());
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  @Override
  public void loginAdministradorOk(Administrador administrador) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void loginError(String mensaje) {
    try {
      response.sendRedirect("index.jsp?mensaje=" + mensaje);
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

}
