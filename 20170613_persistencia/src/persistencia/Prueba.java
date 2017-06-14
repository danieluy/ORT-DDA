/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import mapeo.MapeadorFactura;
import mapeo.MapeadorTarjeta;
import mapeo.MapeadorUsuario;
import modelo.Factura;
import modelo.Tarjeta;

/**
 *
 * @author docenteFI
 */
public class Prueba {

  public static void main(String[] args) {

    BaseDatos bd = BaseDatos.getInstancia();

    String url = "jdbc:mysql://localhost/dda";
    bd.conectar(url, "root", "root");
    Persistencia p = Persistencia.getInstancia();
    
    Factura f = new Factura();
    f.setDatos("Factura 1");
    f.agregarLineas(3, "Chicle");
    f.agregarLineas(14, "Escoba");
    f.agregarLineas(25, "Monitor");
    
    MapeadorFactura mf = new MapeadorFactura();
    mf.setF(f);
    p.guardar(mf);
    System.out.println(f);
    

//    Tarjeta t = new Tarjeta(6546548);
//
//    MapeadorTarjeta mp = new MapeadorTarjeta(t);
//    p.guardar(mp);
//    System.out.println(t);
//    System.out.println(p.obtenerTodos(mp));

    /*mp.setUsuario(u);
        
        ;
        System.out.println(u);
        
        p.borrar(mp);
        System.out.println(u);*/
 /*ArrayList usuarios = p.obtenerTodos(mp);
        System.out.println(usuarios);*/
    bd.desconectar();
  }

}
