/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author docenteFI
 */
public class Linea {

  private int cantidad;
  private String producto;

  public Linea() {
  }

  public Linea(int cantidad, String producto) {
    this.cantidad = cantidad;
    this.producto = producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }

  @Override
  public String toString() {
    return "Linea{" + "cantidad=" + cantidad + ", producto=" + producto + '}';
  }

}
