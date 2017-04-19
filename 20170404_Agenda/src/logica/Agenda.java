package logica;

import java.util.ArrayList;

public class Agenda {
    
    private Usuario dueno;
    private ArrayList<Contacto> contactos = new ArrayList();

    public Agenda(Usuario dueno) {
        this.dueno = dueno;
    }

    public Usuario getDueno() {
        return dueno;
    }
    
    public void agregarContacto(Contacto c) throws AgendaException{
//        Manejar agregar contacto
    }
    
}
