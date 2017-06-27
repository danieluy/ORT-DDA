package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Jugador;

public class MapperJugador implements Mapper {

  private Jugador jugador;

  public MapperJugador() {
  }

  public MapperJugador(Jugador j) {
    jugador = j;
  }

  public void setUsuario(Jugador j) {
    jugador = j;
  }

  @Override
  public int getOid() {
    return jugador.getOid();
  }

  @Override
  public void setOid(int oid) {
    jugador.setOid(oid);
  }

  @Override
  public ArrayList<String> getSQLInsert() {
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
    return "SELECT * FROM jugadores ORDER BY oid";
  }

  @Override
  public void crearNuevo() {
    jugador = new Jugador();
  }

  @Override
  public Object getObjeto() {
    return jugador;
  }

  @Override
  public void leerCompuesto(ResultSet rs) throws SQLException {
    leerComponente(rs);
  }

  @Override
  public void leerComponente(ResultSet rs) throws SQLException {
    jugador.setNombre(rs.getString("nombre"));
    jugador.setNombreCompleto(rs.getString("nombrecompleto"));
    jugador.setPassword(rs.getString("password"));
    jugador.setSaldo(rs.getDouble("saldo"));
  }

}
