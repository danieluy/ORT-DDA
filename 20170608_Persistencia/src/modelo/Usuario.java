/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import persistencia.X;

/**
 *
 * @author docenteFI
 */
public class Usuario implements X{

  private int oid;
  private String nombre;
  private String password;

  public Usuario() {
  }

  public Usuario(String nombre, String password) {
    this.nombre = nombre;
    this.password = password;
  }

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Usuario{" + "oid=" + oid + ", nombre=" + nombre + ", password=" + password + '}';
  }

  @Override
  public String getSqlModificar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getSqlInsertar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
