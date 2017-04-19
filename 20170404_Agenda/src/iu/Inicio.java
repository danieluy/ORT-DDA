package iu;

import logica.Fachada;
import logica.Usuario;

public class Inicio {

    public static void main(String[] args) {
//        Cargar datos de prueba
        crgarDatos();
        new Login(null, false).setVisible(true);
    }

    private static void crgarDatos() {
        Fachada f = Fachada.getInstancia();
        f.agregarUsuario(new Usuario("p", "p", "Pepe"));
        f.agregarUsuario(new Usuario("a", "a", "Ana"));
        f.agregarUsuario(new Usuario("j", "j", "Juan"));
    }
    
}
