package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Persistencia {

  private static Persistencia instancia = new Persistencia();
  private BaseDatos bd = BaseDatos.getInstancia();

  public static Persistencia getInstancia() {
    return instancia;
  }

  private Persistencia() {
  }

  public int proximoOid() {
    try {
      ResultSet rs = bd.consultar("Select valor from identificador");
      rs.next();
      int oid = rs.getInt("valor");
      rs.close();
      oid++;
      bd.modificar("update identificador set valor=" + oid);
      return oid;
    }
    catch (SQLException ex) {
      System.out.println("Error al obtener oid:" + ex.getMessage());
      return -1;
    }
  }

  public void guardar(Mapeador obj) {
    if (obj.getOid() < 1) {
      insertar(obj);
    }
    else {
      modificar(obj);
    }
  }

  private void insertar(Mapeador obj) {
    int oid = proximoOid();
    obj.setOid(oid);
    ArrayList<String> sqls = obj.getSqlInsertar();
    if (!bd.transaccion(sqls)) {
      obj.setOid(0);
      System.out.println("Error al insertar objeto");
    }

  }

  private void modificar(Mapeador obj) {
    ArrayList<String> sqls = obj.getSqlInsertar();
    if (!bd.transaccion(sqls)) {
      System.out.println("Error al modificar objeto");
    }
  }

  public void borrar(Mapeador obj) {
    ArrayList<String> sqls = obj.getSqlInsertar();
    if (bd.transaccion(sqls)) {
      obj.setOid(0); // ya no esta en la base
    }
    else {
      System.out.println("Error al borrar objeto");
    }
  }

  public void restaurar(Mapeador obj) {
    if (obj.getOid() > 0) {
      String sql = obj.getSqlRestaurar();
      ResultSet rs = bd.consultar(sql);
      try {
        rs.next();
        obj.leer(rs);
        rs.close();
      }
      catch (SQLException ex) {
        System.out.println("Error al restaurar:" + ex.getMessage());
      }
    }
  }

  public ArrayList buscar(Mapeador map, String condWhere) {
    String sql = map.getSqlSeleccionar();
    if (condWhere != null) {
      sql += " WHERE " + condWhere;
    }

    ResultSet rs = bd.consultar(sql);
    ArrayList lista = new ArrayList();
    try {

      while (rs.next()) {
        map.crearNuevo();
        map.leer(rs);
        lista.add(map.getObjeto());
      }
    }
    catch (SQLException ex) {
      System.out.println("Error al buscar:" + ex.getMessage());
    }
    return lista;
  }

  public ArrayList obtenerTodos(Mapeador map) {
    return buscar(map, null);
  }

}
