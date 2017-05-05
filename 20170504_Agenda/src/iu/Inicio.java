package iu;

import logica.Fachada;
import logica.Tipo;
import logica.Usuario;

public class Inicio {

     public static void main(String[] args) {
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
