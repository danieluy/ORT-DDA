/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class Contacto {
    
    private String nombre;
    private ArrayList<Telefono> telefonos = new ArrayList();
    
    public void agregar(String nro,Tipo tipo) throws AgendaException{
        
        Telefono t = new Telefono(nro, tipo);
        
        t.validar();
        if(telefonos.contains(t)) throw new AgendaException("Ya existe el telefono");
        
        telefonos.add(t);

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
    
    

    public void validar() throws AgendaException {
        if(nombre==null || nombre.isEmpty()) throw new AgendaException("Falta el nombre");
        if(telefonos.size()==0) throw new AgendaException("Debe tener al menos un telefono");
    }

    @Override
    public String toString() {
        return nombre + " (" + telefonos.size() + ")";
    }
    
    
    
}
