/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import logica.Agenda;
import logica.Fachada;
import logica.Usuario;

/**
 *
 * @author docenteFI
 */
public class ControladorMonitor implements Observer {

  private Fachada modelo = Fachada.getInstancia();
  private ArrayList<Usuario> logueados;
  private VistaMonitor vista;

  public ControladorMonitor(VistaMonitor vista) {
    this.vista = vista;
    modelo.addObserver(this);
    mostrarUsuarios();
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento.equals(Fachada.Eventos.usuario) || evento.equals(Fachada.Eventos.agenda)) {
      mostrarUsuarios();
    }
  }

  private void mostrarUsuarios() {
    logueados = new ArrayList(modelo.getLogueados());
    vista.mostrarUsuarios(logueados);
  }

  public void salir() {
    modelo.deleteObserver(this);
  }

  public void abrirAgenda(int index) {
    if (index > -1) {
      Agenda a = logueados.get(index).getAgenda();
      vista.mostrarAgenda(a);
    }
  }

}
