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
    
    private ArrayList<Telefono> telefonos = new ArrayList();
    private String nombre;
    

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void agregar(String nro, Tipo t) throws AgendaException {
        Telefono tel = new Telefono(nro,t);
        tel.validar(); //este puede lanzar AgendaException
        if(telefonos.contains(tel)) throw new AgendaException("Ya existe");
        
        telefonos.add(tel);
        
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    @Override
    public String toString() {
        return nombre + " (" + telefonos.size() +")";
    }
    public void validar() throws AgendaException{
        if(nombre==null || nombre.isEmpty()) throw new AgendaException("Falta el nombre");
        if(telefonos.size()<1) throw new AgendaException("No tiene telefonos");
    }
    public boolean equals(Object o){
        Contacto c = (Contacto) o;
        return c.nombre.equalsIgnoreCase(nombre);
    }
    
}
