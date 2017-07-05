/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author Dario
 */
public interface VistaLogin {

  public void ingresar(Usuario usuario);

  public void error(String mensaje);

}
