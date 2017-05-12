/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author docenteFI
 */
public class Usuario {
    
    private String nombre;
    private String password;
    private String nombreCompleto;
    private Agenda agenda;

    public Usuario(String nombre, String password, String nombreCompleto) {
        this.nombre = nombre;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }


    
    
    

    
}
