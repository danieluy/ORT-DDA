package logica;

import java.util.ArrayList;
import java.util.Observable;

public class Agenda extends Observable {

    private Usuario dueño;
    private ArrayList<Contacto> contactos = new ArrayList();
    
    public enum Eventos{
        listaContactos;
    }

    public Agenda(Usuario u) {
        dueño = u;
        dueño.setAgenda(this);
    }

    public Usuario getDueño() {
        return dueño;
    }

    private void notificarObservadores(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public void agregar(Contacto c) throws AgendaException {
        c.validar();
        if (contactos.contains(c)) {
            throw new AgendaException("Ya existe el contacto");
        }
        contactos.add(c);
        Fachada.getInstancia().notificarObservadores(Fachada.Eventos.listaContactos);
        notificarObservadores(Agenda.Eventos.listaContactos);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

}
