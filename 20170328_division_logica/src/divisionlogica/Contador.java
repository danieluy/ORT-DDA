/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisionlogica;

/**
 *
 * @author docenteFI
 */
public class Contador {
    
    private int valor;
    
    public void sumar(){
        valor+=2;
    }
    
    public void restar(){
        if(valor>0){
            valor--;
        }
    }

    public int getValor() {
        return valor;
    }
    
    
}
