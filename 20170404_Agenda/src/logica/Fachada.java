package logica;

public class Fachada {

    private static Fachada instancia = new Fachada();
    private SistemaUsuarios su = new SistemaUsuarios();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public void agregarUsuario(Usuario u) {
        su.agregarUsuario(u);
    }

    public Usuario login(String nombre, String password) {
        return su.login(nombre, password);
    }

    public void logout() {
        su.logout();
    }

//    De momento puede quedar oculto de la UI
    protected Usuario getLogueado() {
        return su.getLogueado();
    }
    
    
    
    
}
