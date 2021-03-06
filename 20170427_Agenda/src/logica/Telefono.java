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
public class Telefono {
    
    private String numero;
    private Tipo tipo;

    public Telefono(String numero, Tipo tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
    
    public void validar() throws AgendaException{
        if(numero==null || numero.length()<6) throw new AgendaException("Numero incorrecto");
        if(tipo==null) throw new AgendaException("Falta el tipo");
    }
    
    public boolean equals(Object o){
        Telefono t = (Telefono) o;
        return t.numero.equals(numero);
    }
    public String toString(){
        return numero + " (" + tipo.getNombre().substring(0, 1) + ")";
    }
    
    
}
