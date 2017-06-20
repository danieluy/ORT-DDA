/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public class Factura {

  private int oid;
  private String datos;
  private ArrayList<Linea> lineas = new ArrayList();

  public Factura() {
  }

  public Factura(String datos) {
    this.datos = datos;
  }

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public String getDatos() {
    return datos;
  }

  public void setDatos(String datos) {
    this.datos = datos;
  }

  public ArrayList<Linea> getLineas() {
    return lineas;
  }

  public void agregar(int c, String p) {
    lineas.add(new Linea(c, p));
  }

  @Override
  public String toString() {
    return "\nFactura{" + "oid=" + oid + ", datos=" + datos + ", lineas=" + lineas + '}';
  }

}
