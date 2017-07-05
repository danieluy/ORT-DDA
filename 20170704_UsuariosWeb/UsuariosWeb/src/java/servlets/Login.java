/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControladorLogin;
import controlador.VistaLogin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import vista.LoginFrame;

/**
 *
 * @author Dario
 */
@WebServlet(name = "login", urlPatterns = {"/login"})

public class Login extends HttpServlet implements VistaLogin {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  private HttpServletResponse response;
  private HttpServletRequest request;

  public Login() {
    new LoginFrame().setVisible(true);
  }

  //Este servlet NO  es observador del modelo, aqui no es necesario SSE.
  //Igualmente puede implementar la vista login
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.response = response;
    this.request = request;

    ControladorLogin controlador = new ControladorLogin(this);

    String nombre = request.getParameter("nombre");
    String pass = request.getParameter("password");

    HttpSession sesion = request.getSession(false);
    if (sesion != null)
      sesion.invalidate(); //en cada login limpio la sesion

    controlador.login(nombre, pass);

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
  public void ingresar(Usuario usuario) {

    HttpSession sesion = request.getSession(true);
    sesion.setMaxInactiveInterval(300); //session time out: 30 segundos, si se cierra un navegador o se pierde la conexion 
    //o no hay actividad se hace el logout en el modelo

    sesion.setAttribute("usuario", usuario);
    redirigir("listadoUsuarios.html");
  }

  @Override
  public void error(String mensaje) {
    redirigir("index.jsp?msg=" + mensaje);
  }

  private void redirigir(String url) {
    try {
      response.sendRedirect(url);
    }
    catch (IOException ex) {
      System.out.println("Error al redirigir a " + url + " :" + ex);
    }
  }

}
