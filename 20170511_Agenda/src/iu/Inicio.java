/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import logica.Fachada;
import logica.Tipo;
import logica.Usuario;

/**
 *
 * @author docenteFI
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cargarDatos();
        new Principal().setVisible(true);
        
    }

    private static void cargarDatos() {
        Fachada f = Fachada.getInstancia();
        f.agregar(new Usuario("p","p","Pepe"));
        f.agregar(new Usuario("a","a","Ana"));
        f.agregar(new Usuario("j","j","Juan"));
        
        f.agregar(new Tipo("Particular"));
        f.agregar(new Tipo("Laboral"));
        f.agregar(new Tipo("Celular"));
    }
    
}
