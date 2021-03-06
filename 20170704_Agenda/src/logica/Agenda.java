/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author docenteFI
 */
public class Agenda extends Observable {

  private Usuario dueño;
  private ArrayList<Contacto> contactos = new ArrayList();

  public enum Eventos {
    contactos;
  }

  public Agenda(Usuario dueño) {
    this.dueño = dueño;
    dueño.setAgenda(this);
  }

  private void notificarObservadores(Object evento) {
    setChanged();
    notifyObservers(evento);
  }

  public Usuario getDueño() {
    return dueño;
  }

  public void agregar(Contacto c) throws AgendaException {

    c.validar();
    if (contactos.contains(c))
      throw new AgendaException(c.getNombre() + " ya existe");

    contactos.add(c);
    Fachada.getInstancia().notificarObservadores(Fachada.Eventos.agenda);
    notificarObservadores(Eventos.contactos);
  }

  public ArrayList<Contacto> getContactos() {
    return contactos;
  }

}
