package modelo;

import java.util.ArrayList;

public class Factura {
  private int oid;
  private String datos;
  private ArrayList<Linea> lineas = new ArrayList();

  public Factura(int oid, String datos) {
    this.oid = oid;
    this.datos = datos;
  }

  public Factura() {
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

  public void agregarLineas(int c, String datos) {
    this.lineas.add(new Linea(c, datos));
  }

  @Override
  public String toString() {
    return "\nFactura{" + "oid=" + oid + ", datos=" + datos + ", lineas=" + lineas + '}';
  }
  
  
  
}
