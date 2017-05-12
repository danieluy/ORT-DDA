/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Fachada;
import logica.Usuario;

/**
 *
 * @author docenteFI
 */
public class ControladorLogin {
    
    private Fachada modelo = Fachada.getInstancia();
    private VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(String n,String p){
        Usuario u = modelo.login(n, p);
        if(u==null) vista.mostrarError("Login incorrecto");
        else vista.ingresar(u);
    }
          
    
    
}
