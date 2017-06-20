/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Factura;
import modelo.Linea;
import persistencia.Mapeador;

/**
 *
 * @author docenteFI
 */
public class MapeadorFactura implements Mapeador {

  private Factura f;

  public void setF(Factura f) {
    this.f = f;
  }

  @Override
  public int getOid() {
    return f.getOid();
  }

  @Override
  public void setOid(int oid) {
    f.setOid(oid);
  }

  @Override
  public ArrayList<String> getSqlInsertar() {
    ArrayList<String> sqls = new ArrayList();
    String cabezal = "INSERT INTO cabezal (oid,datos) values "
        + "(" + getOid() + ",'" + f.getDatos() + "')";
    sqls.add(cabezal);
    generarLineas(sqls);
    return sqls;
  }

  private void generarLineas(ArrayList<String> sqls) {
    ArrayList<Linea> lineas = f.getLineas();
    String s;
    Linea l;
    for (int nro = 0; nro < lineas.size(); nro++) {
      l = lineas.get(nro);
      s = "INSERT INTO linea (oid,numero,cantidad,producto) values "
          + "(" + getOid() + "," + (nro + 1) + "," + l.getCantidad()
          + ",'" + l.getProducto() + "')";
      sqls.add(s);
    }
  }

  @Override
  public ArrayList<String> getSqlModificar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ArrayList<String> getSqlBorrar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlRestaurar() {
    return "SELECT * FROM cabezal c,linea l WHERE c.oid=l.oid and c.oid=" + getOid()
        + " ORDER BY l.numero";

  }

  @Override
  public String getSqlSeleccionar() {
    return "SELECT * FROM cabezal c,linea l WHERE c.oid=l.oid ORDER BY c.oid, l.numero";
  }

  @Override
  public void crearNuevo() {
    f = new Factura();
  }

  @Override
  public Object getObjeto() {
    return f;
  }

  @Override
  public void leerCompuesto(ResultSet rs) throws SQLException {
    f.setDatos(rs.getString("datos"));
  }

  @Override
  public void leerComponente(ResultSet rs) throws SQLException {
    f.agregar(rs.getInt("cantidad"), rs.getString("producto"));
  }

}
