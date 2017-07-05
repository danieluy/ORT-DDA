/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author alumnoFI
 */
public class Modelo extends Observable {

  private SistemaUsuarios su = new SistemaUsuarios();
  private static Modelo instancia = new Modelo();

  private Modelo() {
  }

  public static Modelo getInstancia() {
    return instancia;
  }

  public Usuario login(String nombre, String pass) {
    return su.login(nombre, pass);
  }

  public ArrayList<Usuario> getLogueados() {
    return su.getLogueados();
  }

  protected void avisar(Object param) {
    setChanged();
    notifyObservers(param);
  }

  public enum Eventos {
    CambioListaUsuarios;
  }

}
