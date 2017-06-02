package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class Persistencia {

  private static Persistencia instancia = new Persistencia();
  private BaseDatos bd = BaseDatos.getInstancia();

  public static Persistencia getInstancia() {
    return instancia;
  }

  private Persistencia() {
  }

  public int proximoId() {
    try {
      ResultSet rs = bd.consultar("SELECT valor FROM identificador");
      rs.next();
      int oid = rs.getInt("valor");
      rs.close();
      oid++;
      bd.modificar("UPDATE identificador SET valor=" + oid);
      return oid;
    }
    catch (SQLException ex) {
      System.out.println("Error al obtener oid: " + ex.getMessage());
      return -1;
    }
  }

  public void guardar(Usuario obj) {
    if (obj.getOid() < 1) {
      insertar(obj);
    }
    else {
      modificar(obj);
    }
  }

  private void insertar(Usuario obj) {
    int oid = proximoId();
    String sql = "INSERT INTO usuario (oid,nombre,password) VALUES (" + oid + ",'" + obj.getNombre() + "','" + obj.getPassword() + "')";
    int f = bd.modificar(sql);
    if (f > 0) {
      obj.setOid(oid);
    }
    else {
      System.out.println("Error al insertar objeto");
    }
  }

  private void modificar(Usuario obj) {
    String sql = "UPDATE usuario SET nombre='" + obj.getNombre() + "', password='" + obj.getPassword() + "' WHERE oid=" + obj.getOid();
    if (bd.modificar(sql) < 1) {
      System.out.println("Error al modificar objeto");
    }
  }

  public void borrar(Usuario obj) {
    String sql = "DELETE FROM usuario WHERE oid=" + obj.getOid();
    int f = bd.modificar(sql);
    if (f > 0) {
      obj.setOid(0); //ya no está en la DB porque oid == 0s
    }
  }
}
