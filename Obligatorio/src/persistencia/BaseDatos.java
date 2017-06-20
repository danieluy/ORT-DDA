package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

  private Connection connection;

  private static BaseDatos bd = new BaseDatos();

  private BaseDatos() {
  }

  ;
  public static BaseDatos getInstancia() {
    return bd;
  }

  public void conectar(String url, String usuario, String password) {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      connection = DriverManager.getConnection(url, usuario, password);
    }
    catch (Exception ex) {
      System.out.println("Error al conectar: " + ex.getMessage());
    }
  }

  public void desconectar() {
    try {
      connection.close();
    }
    catch (SQLException ex) {
      System.out.println("Error al desconectar:" + ex.getMessage());
    }
  }

  public ResultSet select(String sqlQuery) throws SQLException {
    Statement st = connection.createStatement();
    return st.executeQuery(sqlQuery);
  }

  public boolean transaction(ArrayList<String> sqls) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public void update(String string) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
