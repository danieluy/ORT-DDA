package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Casillero;
import modelo.Movimiento;
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
    String sqlInsertPartida = "INSERT INTO partidas (oid, tamano, ganador, jugador1, jugador2) VALUES ("
        + getOid()
        + ", " + partida.getTamano()
        + ", " + partida.getGanador().getOid()
        + ", " + partida.getJugador1().getOid()
        + ", " + partida.getJugador2().getOid()
        + ")";
    sqls.add(sqlInsertPartida);
    getSqlInsertMovimientos(sqls);
    return sqls;
  }

  private void getSqlInsertMovimientos(ArrayList<String> sqls) {
    ArrayList<Movimiento> movimientos = partida.getMovimientos();
    int i = 0;
    for (Movimiento mov : movimientos) {
      String sqlInsertMovimiento = "INSERT INTO movimientos (oid, oidPartida, jugador, pozo, numeroTurno) VALUES ("
          + "'" + getOid() + "_" + i + "'"
          + ", " + getOid()
          + ", " + mov.getJugador().getOid()
          + ", " + mov.getPozo()
          + ", " + mov.getNumeroTurno()
          + ")";
      sqls.add(sqlInsertMovimiento);
      getSqlInsertCasillero(sqls, (getOid() + "_" + i), mov.getEstadoTablero());
      i++;
    }
  }

  private void getSqlInsertCasillero(ArrayList<String> sqls, String oidMovimiento, ArrayList<Casillero> estado) {
    for (Casillero cas : estado) {
      String sqlInsertCasillero = "INSERT INTO casilleros (oidMovimiento, mina) VALUES ("
          + "'" + oidMovimiento + "'"
          + ", " + (cas.getTipoMina() != null ? ("'" + cas.getTipoMina() + "'") : null)
          + ")";
      sqls.add(sqlInsertCasillero);
    }
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
