package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {

  private static BaseDatos instancia = new BaseDatos();
  private Connection conexion;

  public static BaseDatos getInstancia() {
    return instancia;
  }

  private BaseDatos() {
  }

  public void conectar(String url, String usuario, String password) {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conexion = DriverManager.getConnection(url, usuario, password);
    }
    catch (Exception ex) {
      System.out.println("Error al conectar " + ex.getMessage());
    }
  }

  public void desconectar() {
    try {
      conexion.close();
    }
    catch (SQLException ex) {
    }
  }

  public int modificar(String sql) {
    try {
      Statement stmt = conexion.createStatement();
      int f = stmt.executeUpdate(sql);
      stmt.close();
      return f;
    }
    catch (SQLException ex) {
      System.out.println("Error al conectar " + ex.getMessage());
      System.out.println("SQL: " + sql);
      return -1;
    }
  }

  public ResultSet consultar(String sql) {
    try {
      Statement stmt = conexion.createStatement();
      return stmt.executeQuery(sql);
    }
    catch (SQLException ex) {
      System.out.println("Error al consultar " + ex.getMessage());
      System.out.println("SQL: " + sql);
      return null;
    }
  }

}
