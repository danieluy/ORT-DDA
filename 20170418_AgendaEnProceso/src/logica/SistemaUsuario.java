package logica;

import java.util.ArrayList;

public class SistemaUsuario {
    
    private ArrayList<Usuario> usuarios = new ArrayList();
    private Usuario logueado;
    
    public void agregar(Usuario u){
        usuarios.add(u);
    }
    public Usuario login(String nom,String pwd){
        for(Usuario u:usuarios){
            if(u.getNombre().equalsIgnoreCase(nom) 
               && u.getPassword().equals(pwd)){
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
