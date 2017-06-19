/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import persistencia.Mapeador;

/**
 *
 * @author docenteFI
 */
public class MapeadorUsuario implements Mapeador {

  private Usuario u;

  public MapeadorUsuario() {
  }

  public MapeadorUsuario(Usuario u) {
    this.u = u;
  }

  public void setUsuario(Usuario u) {
    this.u = u;
  }

  @Override
  public int getOid() {
    return u.getOid();
  }

  @Override
  public void setOid(int oid) {
    u.setOid(oid);
  }

  @Override
  public ArrayList<String> getSqlInsertar() {
    String s = "INSERT INTO usuario (oid,nombre,password) values "
        + "(" + getOid() + ",'" + u.getNombre() + "','" + u.getPassword() + "')";
    ArrayList<String> l = new ArrayList();
    l.add(s);
    return l;

  }

  @Override
  public ArrayList<String> getSqlModificar() {
    /*return "UPDATE usuario set nombre = '" + u.getNombre() + "' " +
               ", password = '" + u.getPassword() + "'"+
               " where oid=" + getOid();*/
    return null;

  }

  @Override
  public ArrayList<String> getSqlBorrar() {
    return null; //"DELETE FROM usuario WHERE oid=" + getOid();
  }

  @Override
  public String getSqlRestaurar() {
    return "SELECT * FROM usuario where oid=" + getOid();
  }

  @Override
  public void leerCompuesto(ResultSet rs) throws SQLException {
    u.setNombre(rs.getString("nombre"));
    u.setPassword(rs.getString("password"));

  }

  @Override
  public String getSqlSeleccionar() {
    return "SELECT * FROM usuario";

  }

  @Override
  public void crearNuevo() {
    u = new Usuario();
  }

  @Override
  public Object getObjeto() {
    return u;
  }

  @Override
  public void leerComponente(ResultSet rs) throws SQLException {

  }

}
