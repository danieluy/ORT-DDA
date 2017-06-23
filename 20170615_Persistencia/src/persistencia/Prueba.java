package persistencia;

import mapeo.MapeadorFactura;
import mapeo.MapeadorUsuario;
import modelo.Factura;

public class Prueba {

  public static void main(String[] args) {

    BaseDatos bd = BaseDatos.getInstancia();

    String url = "jdbc:mysql://localhost/dda";
    bd.conectar(url, "root", "root");
    Persistencia p = Persistencia.getInstancia();

    Factura f = new Factura();
    f.setDatos("DATOS FACTURA ");
    f.agregar(3, "papas");
    f.agregar(8, "zapallos");

    MapeadorFactura mf = new MapeadorFactura();
    mf.setF(f);
//    p.guardar(mf);
    System.out.println(f);
    System.out.println(p.obtenerTodos(mf));
    System.out.println(p.obtenerTodos(new MapeadorUsuario()));

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
