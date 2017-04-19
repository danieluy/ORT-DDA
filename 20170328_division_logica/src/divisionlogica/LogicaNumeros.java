/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisionlogica;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class LogicaNumeros {

    private int cantidad;

    private ArrayList<Integer> todos;
    private ArrayList<Integer> pares;
    private ArrayList<Integer> impares;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        todos = new ArrayList();
        pares = new ArrayList();
        impares = new ArrayList();
    }

    public boolean ingresar(int n) {
        if (n == 0) {
            cantidad = todos.size();//hace que al ingresar 0 se muestre el resultado
        }
        if (iniciado() && !fin() && n > -1) {

            if (n % 2 == 0) {
                pares.add(n);
            } else {
                impares.add(n);
            }

            todos.add(n);
            return true;
        }
        return false;
    }

    private boolean iniciado() {
        return cantidad > 0;
    }

    public boolean fin() {
        return iniciado() && cantidad == todos.size();
    }

    public ArrayList<Integer> getResultado() {
        if (fin()) {
            ArrayList<Integer> r = todos;
            if (pares.size() > impares.size()) {
                r = pares;
            } else if (impares.size() > pares.size()) {
                r = impares;
            }
            return r;
        }
        return null;
    }

}
