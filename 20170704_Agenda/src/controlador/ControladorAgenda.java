/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Observable;
import java.util.Observer;
import logica.Agenda;
import logica.AgendaException;
import logica.Contacto;
import logica.Fachada;
import logica.Tipo;

/**
 *
 * @author docenteFI
 */
public class ControladorAgenda implements Observer {

  private VistaAgenda vista;
  private Agenda agenda;
  private Contacto nuevo = new Contacto();

  public ControladorAgenda(VistaAgenda vista, Agenda a) {
    this.vista = vista;
    agenda = a;
    agenda.addObserver(this);
    vista.mostarTiposTelefono(Fachada.getInstancia().getTipos());
    vista.mostrarDueño(agenda.getDueño().getNombreCompleto());
    vista.mostrarContactos(agenda.getContactos());
  }

  public void agregarTelefono(String nro, Tipo tipo) {
    try {
      nuevo.agregar(nro, tipo);
      vista.mostrarTelefonos(nuevo.getTelefonos());
      vista.telefonoAgregado();
    }
    catch (AgendaException ex) {
      vista.mostrarError(ex.getMessage());
    }
  }

  public void crearContacto(String nombre) {

    try {
      nuevo.setNombre(nombre);
      agenda.agregar(nuevo);
      nuevo = new Contacto();
      vista.contactoAgregado();
    }
    catch (AgendaException ex) {
      vista.mostrarError(ex.getMessage());
    }
  }

  public void salir() {
    Fachada.getInstancia().logout(agenda.getDueño());
    agenda.deleteObserver(this);
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento.equals(Agenda.Eventos.contactos)) {
      vista.mostrarContactos(agenda.getContactos());
    }
  }

}
