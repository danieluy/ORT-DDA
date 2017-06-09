/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class Prueba {

  public static void main(String[] args) {

    BaseDatos bd = BaseDatos.getInstancia();

    String url = "jdbc:mysql://localhost/dda";
    bd.conectar(url, "root", "SDFqqeF#RWRfq3RQ135168");
    Persistencia p = Persistencia.getInstancia();
//    //System.out.println("OID:" + p.proximoOid());
//    Usuario u = new Usuario("gonzalo38", "38");
//    p.guardar(u);
//    System.out.println(u);
//
//    p.borrar(u);
//    System.out.println(u);
//
//    p.guardar(u);
//    System.out.println(u);
    ArrayList<Usuario> usuarios = p.buscar("nombre='gonzalo38'");
    System.out.println(usuarios);

    bd.desconectar();
  }

}
