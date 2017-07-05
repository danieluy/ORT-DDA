/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dario
 */
public class SistemaUsuarios {

  private ArrayList<Usuario> usuarios = new ArrayList();

  public SistemaUsuarios() {

    usuarios.add(new Usuario("A", "a", "Adrian Perez"));
    usuarios.add(new Usuario("B", "b", "Beatriz Gonzalez"));
    usuarios.add(new Usuario("C", "c", "Carlos Rodriguez"));
    usuarios.add(new Usuario("D", "d", "Daniel Lopez"));
  }

  public Usuario login(String nombre, String pass) {
    for (Usuario u : usuarios) {
      if (u.getNombre().equalsIgnoreCase(nombre) && u.getPassword().equals(pass)) {
        u.login();
        return u;
      }
    }
    return null;
  }

  public ArrayList<Usuario> getLogueados() {
    ArrayList<Usuario> ret = new ArrayList();
    for (Usuario u : usuarios) {
      if (u.isLogeado())
        ret.add(u);
    }
    return ret;
  }

}
