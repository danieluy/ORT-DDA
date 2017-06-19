/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Tarjeta;
import persistencia.Mapeador;

/**
 *
 * @author docenteFI
 */
public class MapeadorTarjeta implements Mapeador {

  private Tarjeta t;

  public MapeadorTarjeta() {
  }

  public MapeadorTarjeta(Tarjeta t) {
    this.t = t;
  }

  public void setT(Tarjeta t) {
    this.t = t;
  }

  @Override
  public int getOid() {
    return t.getOid();
  }

  @Override
  public void setOid(int oid) {
    t.setOid(oid);
  }

  @Override
  public String getSqlInsertar() {
    Date venc = new Date(t.getVencimiento().getTime());
    return "INSERT INTO tarjeta (oid,numero,vencimiento) values "
        + "(" + getOid() + "," + t.getNumero() + ",'" + venc + "')";

  }

  @Override
  public String getSqlModificar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlBorrar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlRestaurar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void leer(ResultSet rs) throws SQLException {
    t.setOid(rs.getInt("oid"));
    t.setNumero(rs.getInt("numero"));
    t.setVencimiento(rs.getDate("vencimiento"));

  }

  @Override
  public String getSqlSeleccionar() {
    return "SELECT * FROM tarjeta";
  }

  @Override
  public void crearNuevo() {
    t = new Tarjeta();
  }

  @Override
  public Object getObjeto() {
    return t;
  }

}
