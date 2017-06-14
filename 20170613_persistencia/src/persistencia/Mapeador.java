package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Mapeador {

  public int getOid();

  public void setOid(int oid);

  public ArrayList<String> getSqlInsertar();

  public String getSqlModificar();

  public String getSqlBorrar();

  public String getSqlRestaurar();

  public void leer(ResultSet rs) throws SQLException;

  public String getSqlSeleccionar();

  public void crearNuevo();

  public Object getObjeto();

}
