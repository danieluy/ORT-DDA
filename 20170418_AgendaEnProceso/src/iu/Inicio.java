package iu;

import logica.Fachada;
import logica.Tipo;
import logica.Usuario;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cargarDatos();
        new Login(null, true).setVisible(true);
    }

    private static void cargarDatos() {

        Fachada f = Fachada.getInstancia();

        f.agregar(new Usuario("p", "p", "Pepe"));
        f.agregar(new Usuario("a", "a", "Ana"));
        f.agregar(new Usuario("j", "j", "Juan"));

        f.agregar(new Tipo("Celular"));
        f.agregar(new Tipo("Particular"));
        f.agregar(new Tipo("Laboral"));
    }

}
