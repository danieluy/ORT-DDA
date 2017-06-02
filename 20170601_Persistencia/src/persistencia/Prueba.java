package persistencia;

import modelo.Usuario;

public class Prueba {

  public static void main(String[] args) {
    
    BaseDatos bd = BaseDatos.getInstancia();
    Persistencia persistencia = Persistencia.getInstancia();
    
    String url = "jdbc:mysql://localhost/dda";
    bd.conectar(url, "root", "SDFqqeF#RWRfq3RQ135168");

//    String sql;
//    
//    sql = "INSERT INTO usuario (nombre,password) values ('tyler','a')";
//    System.out.println(bd.modificar(sql) + " filas modificadas");

//    Usuario u = new Usuario("nuevo", "n");
//    persistencia.guardar(u);
//    System.out.println(u);


//    Usuario u = new Usuario("lalala", "g");
//    persistencia.guardar(u);
//    System.out.println(u);
//    u.setNombre("Lalala");
//    u.setPassword("pass");
//    persistencia.guardar(u);
//    System.out.println(u);
    
    Usuario u = new Usuario("fooooo", "g");
    persistencia.guardar(u);
    System.out.println(u);
    persistencia.borrar(u);
    System.out.println(u);
    persistencia.guardar(u);
    System.out.println(u);
    
    bd.desconectar();
  }
}
