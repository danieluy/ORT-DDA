package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Partida;

public class MapperPartida implements Mapper {

  private Partida partida;

  public void setPartida(Partida partida) {
    this.partida = partida;
  }

  @Override
  public int getOid() {
    return partida.getOid();
  }

  @Override
  public void setOid(int oid) {
    partida.setOid(oid);
  }

  @Override
  public ArrayList<String> getSqlInsert() {
    ArrayList<String> sqls = new ArrayList();
    String sql_partida = "INSERT INTO partidas (oid, tamano, ganador, jugador1, jugador2) VALUES ("
        + getOid()
        + ", " + partida.getTamano()
        + ", " + partida.getGanador().getOid()
        + ", " + partida.getJugador1().getOid()
        + ", " + partida.getJugador2().getOid()
        + ")";
    System.out.println("sql_partida " + sql_partida);
    sqls.add(sql_partida);
    return sqls;
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void crearNuevo() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Object getObjeto() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void leerCompuesto(ResultSet rs) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void leerComponente(ResultSet rs) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
