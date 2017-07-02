package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Casillero;
import modelo.Modelo;
import modelo.Jugador;
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
  public ArrayList<String> getSQLInsert() {
    ArrayList<String> sqls = new ArrayList();
    String sqlInsertPartida = "INSERT INTO partidas (oid, tamano, ganador, jugador1, jugador2) VALUES ("
        + getOid()
        + ", " + partida.getTamano()
        + ", " + partida.getGanador().getOid()
        + ", " + partida.getJugador1().getOid()
        + ", " + partida.getJugador2().getOid()
        + ")";
    sqls.add(sqlInsertPartida);
    getSQLInsertMovimientos(sqls);
    return sqls;
  }

  private void getSQLInsertMovimientos(ArrayList<String> sqls) {
    ArrayList<Movimiento> movimientos = partida.getMovimientos();
    for (int i = 0; i < movimientos.size(); i++) {
      Movimiento mov = movimientos.get(i);
      String sqlInsertMovimiento = "INSERT INTO movimientos (nro, oidPartida, jugador, pozo, numeroTurno) VALUES ("
          + i
          + ", " + getOid()
          + ", " + mov.getJugador().getOid()
          + ", " + mov.getPozo()
          + ", " + mov.getNumeroTurno()
          + ")";
      sqls.add(sqlInsertMovimiento);
      getSQLInsertCasillero(sqls, i, mov.getEstadoTablero());
    }
  }

  private void getSQLInsertCasillero(ArrayList<String> sqls, int nroMovimiento, ArrayList<Casillero> casilleros) {
    for (int i = 0; i < casilleros.size(); i++) {
      Casillero casillero = casilleros.get(i);
      String sqlInsertCasillero = "INSERT INTO casilleros (nro, nroMovimiento, oidPartida, mina, color) VALUES ("
          + i
          + ", " + nroMovimiento
          + ", " + getOid()
          + ", " + (casillero.getTipoMina() != null ? ("'" + casillero.getTipoMina() + "'") : null)
          + ", " + "'" + casillero.getColorRGB() + "'"
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
    String sqlSelectPartida = "SELECT p.oid, p.tamano, p.ganador, p.jugador1, p.jugador2, m.nro movimiento, m.jugador oidJugadorMovimiento, m.pozo, m.numeroTurno, c.nro nroCasillero, c.mina, c.color "
        + "FROM partidas p, movimientos m, casilleros c "
        + "WHERE p.oid = m.oidPartida "
        + "AND p.oid = c.oidPartida "
        + "AND m.nro = c.nroMovimiento "
        + "ORDER BY p.oid, m.nro, c.nro";
    return sqlSelectPartida;
  }

  @Override
  public void crearNuevo() {
    partida = new Partida();
  }

  @Override
  public Object getObjeto() {
    return partida;
  }

  @Override // Lee Partida
  public void leerCompuesto(ResultSet rs) throws SQLException {
    // Restaurar Partida
    int tamano = rs.getInt("tamano");
    int oidGanador = rs.getInt("ganador");
    int oidJugador1 = rs.getInt("jugador1");
    int oidJugador2 = rs.getInt("jugador2");
    partida.restaurarDesdeBD(tamano, oidGanador, oidJugador1, oidJugador2);
  }

  @Override // Lee Movimiento
  public void leerComponente(ResultSet rs) throws SQLException {
    // Para crear un nuevo Movimiento el número de movimiento debe coincidir con la primera posicion disponible de
    // ArrayList<Movimiento> Partida.movimientos, de lo contrario leemos Casillero
    // Siempre número de movimiento va a ser manor o igual a partida.getMovimientos().size()
    if (partida.getMovimientos().size() == rs.getInt("movimiento")) {
      Movimiento movimiento = new Movimiento();
      Jugador jugador = Modelo.getInstancia().getJugadorByOid(rs.getInt("oidJugadorMovimiento"));
      double pozo = rs.getDouble("pozo");
      int numeroTurno = rs.getInt("numeroTurno");
      movimiento.restaurarDesdeBD(jugador, pozo, numeroTurno);
      partida.addMovimientoDesdeBD(movimiento);
    }
    // En todos los casos consigo el casillero de la fila
    getCasillero(rs);
  }
  // Lee Casillero
  private void getCasillero(ResultSet rs) throws SQLException {
    ArrayList<Movimiento> movimientos = partida.getMovimientos();
    Movimiento movimiento = movimientos.get(movimientos.size() - 1);
    Casillero casillero = new Casillero();
    casillero.restaurarDesdeBD(rs.getString("mina"), rs.getString("color"));
    movimiento.addCasilleroDesdeBD(casillero);
  }
}
