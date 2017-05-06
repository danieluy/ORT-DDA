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
public class Fachada {

    private static Fachada instancia = new Fachada();
    private SistemaUsuario su = new SistemaUsuario();
    private SistemaAgenda sa = new SistemaAgenda();

    public static Fachada getInstancia() {
        return instancia;
    }

    public void agregar(Tipo t) {
        sa.agregar(t);
    }

    public ArrayList<Tipo> getTipos() {
        return sa.getTipos();
    }

    public Agenda getAgenda() {
        return sa.getAgenda();
    }

    private Fachada() {
    }

    public void agregar(Usuario u) {
        su.agregar(u);
    }

    public Usuario login(String nom, String pwd) {
        return su.login(nom, pwd);
    }

    public void logout() {
        su.logout();
    }

    protected Usuario getLogueado() {
        return su.getLogueado();
    }

}
