package controlador;

import java.util.Observable;
import java.util.Observer;
import logica.Agenda;
import logica.AgendaException;
import logica.Contacto;
import logica.Fachada;
import logica.Tipo;
import vista.AgendaVista;

public class AgendaControlador implements Observer {

    private AgendaVista vista;
    private Agenda agenda;
    private Contacto nuevoContacto = new Contacto();

    public AgendaControlador(AgendaVista vista, Agenda a) {
        this.vista = vista;
        agenda = a;
        agenda.addObserver(this);
        vista.mostratTiposTelefono(Fachada.getInstancia().getTipos());
        vista.mostrarDueno(agenda.getDueño().getNombreCompleto());
        vista.mostrarContactos(agenda.getContactos());
    }

    public void salir() {
        Fachada.getInstancia().logout(agenda.getDueño());
    }

    public void agregarTelefono(String numero, Tipo tipo) {
        try {
            nuevoContacto.agregar(numero, tipo);
            vista.mostrarTelefonos(nuevoContacto.getTelefonos());
        } catch (AgendaException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void crearContacto(String nombre) {
        try {
            nuevoContacto.setNombre(nombre);
            agenda.agregar(nuevoContacto);
            nuevo();
        } catch (AgendaException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void nuevo() {
        nuevoContacto = new Contacto();
        vista.limpiarNombre();
        vista.mostrarTelefonos(nuevoContacto.getTelefonos());
    }

    @Override
    public void update(Observable o, Object evento) {
        if (evento == Agenda.Eventos.contactos) {
            vista.mostrarContactos(agenda.getContactos());
        }
    }

}
