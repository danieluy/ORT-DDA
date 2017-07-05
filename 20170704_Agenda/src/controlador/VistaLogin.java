/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Usuario;

/**
 *
 * @author docenteFI
 */
public interface VistaLogin {

  public void mostrarError(String mensaje);

  public void ingresar(Usuario u);

}
