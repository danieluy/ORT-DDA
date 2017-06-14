package mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Factura;
import modelo.Linea;
import persistencia.Mapeador;

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
    String cabezal = "INSERT INTO cabezal (oid, datos) VALUES (" + getObjeto() + ", '" + f.getDatos() + "')";
    sqls.add(cabezal);
    generarLineas(sqls);
    return sqls;
  }

  private void generarLineas(ArrayList<String> sqls) {
    ArrayList<Linea> lineas = f.getLineas();
    String s;
    Linea l;
    for (int i = 0; i < lineas.size(); i++) {
      l = lineas.get(i);
      s = "INSERT INTO linea (oid, cantidad, producto, numero) VALUES " + "(" + getOid() + ", " + (i+1) + ", " + l.getCantidad() + ", '" + l.getProducto() + "')";
      sqls.add(s);
    }
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlSeleccionar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void crearNuevo() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Object getObjeto() {
    return f;
  }
  
}
