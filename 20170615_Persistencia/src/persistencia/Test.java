/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author docenteFI
 */
public class Test {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      // TODO code application logic here

      String url = "jdbc:mysql://localhost/dda";
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      Connection conexion = DriverManager.getConnection(url, "root", "root");
      System.out.println("Conectado!");

      //CAMBIOS
      Statement stmt = conexion.createStatement();
      String sql;
      /*sql = "INSERT INTO usuario (nombre,password) " +
                         " values ('juan','j')";*/

      //sql = "DELETE FROM usuario";
      sql = "UPDATE usuario set password = 'z'";

      int f = stmt.executeUpdate(sql);
      System.out.println(f + " filas afectadas");

      //CONSULTAS
      ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
      while (rs.next()) {
        System.out.println("------");
        System.out.println("Nombre:" + rs.getString("nombre"));
        System.out.println("Password:" + rs.getString("password"));
      }

      rs.close();
      stmt.close();
      conexion.close();
      System.out.println("Desconectado!");

    }
    catch (SQLException ex) {

      System.out.println("Error sql:" + ex.getMessage());
      System.out.println("Codigo:" + ex.getErrorCode());

    }
    catch (Exception ex) {

      System.out.println("Error desconocido:" + ex.getMessage());
      ex.printStackTrace();
    }
  }

}
