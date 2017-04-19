package logica;

import java.util.ArrayList;

public class Agenda {

    private Usuario dueño;
    private ArrayList<Contacto> contactos = new ArrayList();

    public Agenda(Usuario u) {
        dueño = u;
    }

    public Usuario getDueño() {
        return dueño;
    }

    public void agregar(Contacto c) throws AgendaException {
        c.validar();// throws AgendaException
        if (contactos.contains(c)) {
            throw new AgendaException("Ya existe el contacto");
        }
        contactos.add(c);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    

}
