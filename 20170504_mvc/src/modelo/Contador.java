/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;

/**
 *
 * @author docenteFI
 */
public class Contador extends Observable{
    
    private int valor;
    private static Contador instancia = new Contador();

    public static Contador getInstancia() {
        return instancia;
    }

    private Contador() {
    }
        
    public enum Eventos{
        cambioValor;
    }
    private void notificarObservadores(Object evento){
        setChanged();
        notifyObservers(evento);
    }
    public void sumar(){
        valor+=2;
        notificarObservadores(Eventos.cambioValor);
    }
    
    public void restar() throws ContadorException{
        if(valor==0)throw new ContadorException("No puede ser negativo");
        valor--;
        notificarObservadores(Eventos.cambioValor);
        
    }

    public int getValor() {
        return valor;
    }
    
    
}
