package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Administrador;

public class MapperAdministrador implements Mapper {
  
  private Administrador administrador;

  @Override
  public int getOid() {
    return administrador.getOid();
  }

  @Override
  public void setOid(int oid) {
    administrador.setOid(oid);
  }

  @Override
  public ArrayList<String> getSqlInsert() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ArrayList<String> getSqlUpdate() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ArrayList<String> getSqlDelete() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlRestore() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlSelect() {
    return "SELECT * FROM administradores";
  }

  @Override
  public void crearNuevo() {
    administrador = new Administrador();
  }

  @Override
  public Object getObjeto() {
    return administrador;
  }

  @Override
  public void leerCompuesto(ResultSet rs) throws SQLException {
    leerComponente(rs);
  }

  @Override
  public void leerComponente(ResultSet rs) throws SQLException {
    administrador.setNombre(rs.getString("nombre"));
    administrador.setNombreCompleto(rs.getString("nombrecompleto"));
    administrador.setPassword(rs.getString("password"));
  }

}
