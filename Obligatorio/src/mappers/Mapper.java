package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Mapper {

  public int getOid();

  public void setOid(int oid);

  public ArrayList<String> getSQLInsert();

  public ArrayList<String> getSqlUpdate();

  public ArrayList<String> getSqlDelete();

  public String getSqlRestore();

  public String getSqlSelect();

  public void crearNuevo();

  public Object getObjeto();

  public void leerCompuesto(ResultSet rs) throws SQLException;

  public void leerComponente(ResultSet rs) throws SQLException;
  
}
