/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaWeb;

import controlador.ControladorAgenda;
import controlador.VistaAgenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.AsyncContext;
import logica.Contacto;
import logica.Telefono;
import logica.Tipo;
import logica.Usuario;
import utilidades.Componentes;

/**
 *
 * @author docenteFI
 */

public class VistaAgendaWeb implements VistaAgenda{
    
    private ControladorAgenda controlador;
    private AsyncContext contexto;
    private PrintWriter out;
    
    public void inicializar(Usuario u,AsyncContext c){
        contexto = c;
        try {
            out = contexto.getResponse().getWriter();
        } catch (IOException ex) {
           
        }
        controlador = new ControladorAgenda(this,u.getAgenda());
    }
     public void enviar(String evento, String dato) {
    
        out.write("event: " + evento + "\n");
        dato = dato.replace("\n", "");
        out.write("data: " + dato + "\n\n");
        if (out.checkError()) {//checkError llama a flush, si da false evio bien
            cerrar();            
        } else {
            //TODO OK!
            // System.out.println("Enviado");
        }
    }
     private void cerrar(){
        controlador.salir();
         try{
             contexto.complete(); //finalizo el contexto asincronico
         }catch(Exception e){}   
    }

    @Override
    public void mostarTiposTelefono(ArrayList<Tipo> tipos) {
        enviar("tiposTel",Componentes.lista(false, "lstTipos", tipos));
    }

    @Override
    public void mostrarDueño(String nombreCompleto) {
       enviar("duenio",nombreCompleto.toUpperCase());
    }

    @Override
    public void mostrarContactos(ArrayList<Contacto> contactos) {
          enviar("contactos",Componentes.lista(true, "lstContactos", contactos));
    }

    @Override
    public void mostrarError(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarTelefonos(ArrayList<Telefono> telefonos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contactoAgregado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void telefonoAgregado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
