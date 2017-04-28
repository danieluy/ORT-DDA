package logica;

import java.util.ArrayList;
import java.util.Observable;

public class Fachada extends Observable {

    private static Fachada instancia = new Fachada();
    private SistemaUsuario su = new SistemaUsuario();
    private SistemaAgenda sa = new SistemaAgenda();

    public ArrayList<Usuario> getLogueados() {
        return su.getLogueados();
    }

   

    public enum Eventos {
        listaLogueados, listaContactos;
    }

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
        notificarObservadores(null);
    }

    protected void notificarObservadores(Object evento) {
        setChanged();
        notifyObservers(evento);
    }

    public void agregar(Usuario u) {
        su.agregar(u);
    }

    public Usuario login(String nom, String pwd) {
        return su.login(nom, pwd);
    }

    public void logout(Usuario u) {
        su.logout(u);
    }

    public void agregar(Tipo t) {
        sa.agregar(t);
    }

    public ArrayList<Tipo> getTipos() {
        return sa.getTipos();
    }

    protected void asignarAgenda(Usuario u) {
        sa.asignarAgenda(u);
    }

}
