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
public class SistemaAgendas {
    
    private ArrayList<Tipo> tipos = new ArrayList();
    private ArrayList<Agenda> agendas = new ArrayList();

    public void agregar(Tipo t){
        tipos.add(t);
    }
    public ArrayList<Tipo> getTipos() {
        return tipos;
    }
    public void asignarAgenda(Usuario u){
        Agenda agenda = u.getAgenda();
         if(agenda==null){ //es la primera vez que ingresa
            agenda = new Agenda(u);
            agendas.add(agenda);
        }
        
    }
    
    
}
