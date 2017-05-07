/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author docenteFI
 */
public class Fachada extends Observable{
    
    private SistemaUsuarios su = new SistemaUsuarios();
    private SistemaAgendas sa = new SistemaAgendas();
    
    private static Fachada instancia = new Fachada();

    public enum Eventos{
        usuario,agenda;
    }
    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }
    //DELEGACIONES
    public void agregar(Usuario u) {
        su.agregar(u);
        
    }
    protected void notificarObservadores(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    public Usuario login(String nom, String pass) {
        return su.login(nom, pass);
    }
    /*protected Usuario getLogueado() {
        return su.getLogueado();
    }*/

    public void agregar(Tipo t) {
        sa.agregar(t);
    }

    public ArrayList<Tipo> getTipos() {
        return sa.getTipos();
    }

    protected void asignarAgenda(Usuario u) {
         sa.asignarAgenda(u);
    }

    public void logout(Usuario u) {
        su.logout(u);
    }

    public ArrayList<Usuario> getLogueados() {
        return su.getLogueados();
    }

    
    
    

    
    
    
    
}
