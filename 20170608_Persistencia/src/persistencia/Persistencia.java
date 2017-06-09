/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author docenteFI
 */
public class Persistencia {

  private static Persistencia instancia = new Persistencia();
  private BaseDatos bd = BaseDatos.getInstancia();

  public static Persistencia getInstancia() {
    return instancia;
  }

  private Persistencia() {
  }

  public int proximoOid() {
    try {
      ResultSet rs = bd.consultar("Select valor from identificador");
      rs.next();
      int oid = rs.getInt("valor");
      rs.close();
      oid++;
      bd.modificar("update identificador set valor=" + oid);
      return oid;
    }
    catch (SQLException ex) {
      System.out.println("Error al obtener oid:" + ex.getMessage());
      return -1;
    }
  }

  public void guardar(X obj) {
    if (obj.getOid() < 1)
      insertar(obj);
    else
      modificar(obj);
  }

  private void insertar(X obj) {
    int oid = proximoOid();
    String sql = "INSERT INTO usuario (oid,nombre,password) values "
        + "(" + oid + ",'" + obj.getNombre() + "','" + obj.getPassword() + "')";
    int f = bd.modificar(sql);
    if (f > 0)
      obj.setOid(oid);
    else
      System.out.println("Error al insertar objeto");

  }

  private void modificar(X obj) {
    String sql = "UPDATE usuario set nombre = '" + obj.getNombre() + "' "
        + ", password = '" + obj.getPassword() + "'"
        + " where oid=" + obj.getOid();
    if (bd.modificar(sql) < 1) {
      System.out.println("Error al modificar objeto");
    }
  }

  public void borrar(Usuario obj) {
    String sql = "DELETE FROM usuario WHERE oid=" + obj.getOid();
    int f = bd.modificar(sql);
    if (f > 0)
      obj.setOid(0); //ya no esta en la base
  }
  
  public void restaurar(Usuario u){
    if(u.getOid() > 0){
      try {
        String sql = "SELECT * FROM usuario WHERE oid=" + u.getOid();
        ResultSet rs = bd.consultar(sql);
        rs.next();
        leer(u, rs);
        rs.close();
      }
      catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  private void leer(Usuario u, ResultSet rs) throws SQLException {
    u.setOid(rs.getInt("oid"));
    u.setNombre(rs.getString("nombre"));
    u.setPassword(rs.getString("password"));
  }
  
  public ArrayList<Usuario> buscar(String where){
    String sql = "SELECT * FROM usuario";
    if(where != null)
      sql += " WHERE " + where;
    ResultSet rs = bd.consultar(sql);
    ArrayList<Usuario> lista = new ArrayList();
    try {
      while(rs.next()){
        Usuario u = new Usuario();
        leer(u, rs);
        lista.add(u);
      }
    }
    catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return lista;
  }

}
