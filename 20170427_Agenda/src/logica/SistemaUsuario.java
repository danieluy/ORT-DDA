package logica;

import java.util.ArrayList;

public class SistemaUsuario {

    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Usuario> logueados = new ArrayList();

    public void agregar(Usuario u) {
        usuarios.add(u);
    }

    public Usuario login(String nom, String pwd) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nom) && u.getPassword().equals(pwd)) {
                logueados.add(u);
                Fachada.getInstancia().asignarAgenda(u);
                Fachada.getInstancia().notificarObservadores(Fachada.Eventos.listaLogueados);
                return u;
            }
        }
        return null;
    }

    public void logout(Usuario u) {
        logueados.remove(u);
        Fachada.getInstancia().notificarObservadores(Fachada.Eventos.listaLogueados);
    }

    public ArrayList<Usuario> getLogueados() {
        return logueados;
    }

    public void setLogueados(ArrayList<Usuario> logueados) {
        this.logueados = logueados;
    }
}
