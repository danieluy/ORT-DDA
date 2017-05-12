/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import logica.Agenda;
import logica.Usuario;

/**
 *
 * @author docenteFI
 */
public interface VistaMonitor {

    public void mostrarUsuarios(ArrayList<Usuario> logueados);

    public void mostrarAgenda(Agenda a);
    
}
