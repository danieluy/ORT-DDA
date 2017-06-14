package modelo;

public class Linea {
  private int cantidad;
  private String producto;

  public Linea(int cantidad, String producto) {
    this.cantidad = cantidad;
    this.producto = producto;
  }

  public Linea() {
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
