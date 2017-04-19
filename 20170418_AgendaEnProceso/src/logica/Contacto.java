package logica;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class Contacto {

    private ArrayList<Telefono> telefonos = new ArrayList();
    private String nombre;

    public void agregar(String nro, Tipo t) throws AgendaException {
        Telefono tel = new Telefono(nro, t);
        tel.validar(); //throws AgendaException
        if (telefonos.contains(tel)) {
            throw new AgendaException("Ya existe");
        }
        telefonos.add(tel);
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + telefonos.size() + ")";
    }

    public void validar() throws AgendaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new AgendaException("Falta el nombre");
        }
        if (telefonos.size() < 1) {
            throw new AgendaException("No tiene teléfonos");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Contacto c = (Contacto) obj;
        return c.nombre.equalsIgnoreCase(nombre);
    }
    
    

}
