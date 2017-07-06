/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controlador.ControladorLogin;
import controlador.VistaLogin;
import iu.Inicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;

/**
 *
 * @author docenteFI
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet implements VistaLogin{
    
    private HttpServletRequest request;
    private HttpServletResponse response;

    public LoginServlet() {
        Inicio.main(null);
    }

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.response = response;
        this.request = request;
        
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        
        ControladorLogin controlador = new ControladorLogin(this);
        controlador.login(nombre, password);
        
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
    public void mostrarError(String mensaje) {
        try {
            response.sendRedirect("index.jsp?msg=" + mensaje);
        } catch (IOException ex) {
                System.out.println("Error redirect");
        }
    }
    @Override
    public void ingresar(Usuario u) {
          try {
            request.getSession(true).setAttribute("usuario", u);
            response.sendRedirect("agenda.html");
        } catch (IOException ex) {
                System.out.println("Error redirect");
        }
    }

}
