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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return numero + " - " + tipo.getNombre();
    }

    public void validar() throws AgendaException {
        if(tipo==null) throw new AgendaException("Falta el tipo");
        if(numero==null || numero.isEmpty()) throw new AgendaException("Falta el numero");
        
    }
    
    public boolean equals(Object o){
        Telefono t = (Telefono) o;
        return numero.equals(t.getNumero());
    }
}
