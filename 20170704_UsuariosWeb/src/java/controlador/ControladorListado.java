/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import modelo.Modelo;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class ControladorListado implements Observer {

  private Modelo modelo = Modelo.getInstancia();
  private VistaListado vista;
  private Usuario usuario;

  public ControladorListado(VistaListado vista, Usuario u) {
    this.vista = vista;
    usuario = u;
    modelo.addObserver(this);
    actualizarVista();
  }

  @Override
  public void update(Observable o, Object arg) {
    if (arg.equals(Modelo.Eventos.CambioListaUsuarios)) {

      actualizarVista();
    }
  }

  private void actualizarVista() {
    if (usuario.isLogeado()) {
      vista.mostrar(usuario);
      vista.mostarContador(usuario.getContador());
    }
    else
      vista.mostrar((Usuario) null);
    vista.mostrar(modelo.getLogueados());
  }

  public void salir() {

    modelo.deleteObserver(this);
  }

  public void logout() {
    usuario.logout();
  }

  public void logout(Usuario otro) {
    otro.logout();
  }
}
