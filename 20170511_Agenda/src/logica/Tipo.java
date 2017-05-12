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
public class Tipo {
    
    private String nombre;
    //private ArrayList<Telefono> telefonos = new ArrayList();

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/*    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }
    public void agregar(Telefono t) {
        telefonos.add(t);
    }*/

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
}
