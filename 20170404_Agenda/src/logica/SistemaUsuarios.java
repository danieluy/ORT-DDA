package logica;

import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario logueado;

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public Usuario login(String nombre, String password) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre) && u.getPassword().equals(password)) {
                logueado = u;
                return u;
            }
        }
        return null;
    }
    
    public void logout(){
        logueado = null;
    }

    public Usuario getLogueado() {
        return logueado;
    }
    
    
}
