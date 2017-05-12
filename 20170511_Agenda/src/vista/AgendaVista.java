package vista;

import java.util.ArrayList;
import logica.Contacto;
import logica.Telefono;
import logica.Tipo;

public interface AgendaVista {

    public void mostratTiposTelefono(ArrayList<Tipo> tipos);

    public void mostrarDueno(String nombreCompleto);

    public void mostrarContactos(ArrayList<Contacto> contactos);

    public void mostrarError(String message);

    public void mostrarTelefonos(ArrayList<Telefono> telefonos);

    public void limpiarNombre();
    
}
