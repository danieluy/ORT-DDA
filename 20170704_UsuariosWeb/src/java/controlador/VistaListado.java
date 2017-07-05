/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public interface VistaListado {

  public void mostrar(ArrayList<Usuario> usuarios);

  public void mostrar(Usuario actual);

  public void mostarContador(int contador);

}
