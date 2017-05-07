/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class SistemaUsuarios {
    
    private ArrayList<Usuario> usuarios = new ArrayList();
    private ArrayList<Usuario> logueados = new ArrayList();
    
    public void agregar(Usuario u){
        usuarios.add(u);
    }
    public Usuario login(String nom,String pass){
        for(Usuario u:usuarios){
            if(u.getNombre().equals(nom) && u.getPassword().equals(pass)){
                    logueados.add(u);
                    Fachada.getInstancia().asignarAgenda(u);
                    Fachada.getInstancia().notificarObservadores(Fachada.Eventos.usuario);
                     return u;
                }
            }
        return null;
    }

    /*public Usuario getLogueado() {
        return logueado;
    }*/
    public void logout(Usuario u){
        logueados.remove(u);
        Fachada.getInstancia().notificarObservadores(Fachada.Eventos.usuario);
    }

    public ArrayList<Usuario> getLogueados() {
        return logueados;
    }
    
    
}
