package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

  private Connection con;

  private static BaseDatos bd = new BaseDatos();

  private BaseDatos() {
  }

  public static BaseDatos getInstancia() {
    return bd;
  }

  public void conectar(String url, String usuario, String password) {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      con = DriverManager.getConnection(url, usuario, password);
    }
    catch (Exception ex) {
      System.out.println("Error al conectar: " + ex.getMessage());
    }
  }

  public void desconectar() {
    try {
      con.close();
    }
    catch (SQLException ex) {
      System.out.println("Error al desconectar:" + ex.getMessage());
    }
  }

  public ResultSet select(String sqlQuery) throws SQLException {
    Statement st = con.createStatement();
    return st.executeQuery(sqlQuery);
  }

  // La transacción es básicamente poner los commits en manual hasta temrinar de hacer cada uno de los necesarios
  // y después los dejamos como estaban para que el resto de las operaciones puedan usar la conexión normalmente
  public boolean transaction(ArrayList<String> sqls) {
    try {
      con.setAutoCommit(false); //comenzar transacción
      for (String sql : sqls) {
        if (execute(sql) < 1) {
          con.rollback();
          return false;
        }
      }
      con.commit();
      return true;
    }
    catch (SQLException e) {
      System.out.println("Error al ejecutar transaccion:" + e.getMessage());
      return false;
    }
    finally {
      try {
        con.setAutoCommit(true); //terminar transacción
      }
      catch (SQLException ex) {
        System.out.println("Error grave:" + ex.getMessage());
      }
    }
  }

  public int execute(String sql) {
    try {
      Statement statement = con.createStatement();
      int filas_afectadas = statement.executeUpdate(sql);
      statement.close();
      return filas_afectadas;
    }
    catch (SQLException ex) {
      System.out.println("Error al modificar:" + ex.getMessage());
      System.out.println("SQL:" + sql);
      return -1;
    }
  }

}
