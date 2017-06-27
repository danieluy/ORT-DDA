package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mappers.Mapper;

public class Persistencia {

  private BaseDatos bd = BaseDatos.getInstancia();

  private static Persistencia persistencia = new Persistencia();

  private Persistencia() {
  }

  public static Persistencia getInstancia() {
    return persistencia;
  }

  public int nextOid() {
    try {
      ResultSet rs = bd.select("SELECT valor FROM oid");
      rs.next();
      int oid = rs.getInt("valor");
      rs.close();
      oid++;
      bd.execute("UPDATE oid SET valor=" + oid);
      return oid;
    }
    catch (SQLException ex) {
      System.out.println("Error al obtener oid:" + ex.getMessage());
      return -1;
    }
  }

  public void save(Mapper map) {
    if (map.getOid() < 1)
      insert(map);
    else
      update(map);
  }

  private void insert(Mapper map) {
    int oid = nextOid();
    map.setOid(oid);
    ArrayList<String> sqls = map.getSQLInsert();
    if (!bd.transaction(sqls)) {
      map.setOid(0);
      System.out.println("Error al insertar objeto");
    }
  }

  private void update(Mapper map) {
    ArrayList<String> sqls = map.getSqlUpdate();
    if (!bd.transaction(sqls)) {
      System.out.println("Error al modificar objeto");
    }
  }

  public void delete(Mapper map) {
    ArrayList<String> sqls = map.getSqlDelete();
    if (bd.transaction(sqls))
      map.setOid(0); //ya no esta en la base
    else
      System.out.println("Error al borrar objeto");
  }

  public void restore(Mapper map) {
    if (map.getOid() > 0) {
      try {
        String sql = map.getSqlRestore();
        ResultSet rs = bd.select(sql);
        while (rs.next()) {
          if (rs.getRow() == 1) {
            map.leerComponente(rs);
          }
          map.leerCompuesto(rs);
        }
        rs.close();
      }
      catch (SQLException ex) {
        System.out.println("Error al restaurar:" + ex.getMessage());
      }
    }
  }

  public ArrayList select(Mapper map, String where) {
    String sql = map.getSqlSelect(); // ordenado por oid
    if (where != null)
      sql += " WHERE " + where;
    ArrayList lista = new ArrayList();
    try {
      ResultSet rs = bd.select(sql);
      int oid, oidAnterior = -1;
      while (rs.next()) {
        oid = rs.getInt("oid"); // el campo oid tiene que existir con ese nombre en la base de datos
        if (oid != oidAnterior) { // cambió oid
          map.crearNuevo();
          map.setOid(oid);
          lista.add(map.getObjeto());
          map.leerCompuesto(rs);
          oidAnterior = oid;
        }
        map.leerComponente(rs);
      }
    }
    catch (SQLException ex) {
      System.out.println("Error al buscar: " + ex.getMessage());
    }
    return lista;
  }

  public ArrayList selectAll(Mapper map) {
    return select(map, null);
  }
}
