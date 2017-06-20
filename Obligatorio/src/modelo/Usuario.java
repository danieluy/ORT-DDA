package modelo;

public class Usuario {

  private int oid;
  private String nombre;
  private String password;
  private String nombreCompleto;

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public enum TiposUsuario {
    jugador, administrador
  }

  public Usuario() {
  }

  public Usuario(String nombre, String nombreCompleto, String password) {
    this.nombre = nombre;
    this.nombreCompleto = nombreCompleto;
    this.password = password;
  }

  public void validar() throws UsuarioException {
    if (nombre.isEmpty() || password.isEmpty() || nombreCompleto.isEmpty())
      throw new UsuarioException("Faltan datos de usuario");
  }

//Getters & Setters
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  @Override
  public boolean equals(Object o) {
    return ((Usuario) o).getNombre().equalsIgnoreCase(nombre);
  }

  @Override
  public String toString() {
    return "oid: " + oid + ", nombre: " + nombre + ", password: " + password + ", nombreCompleto: " + nombreCompleto;
  }

}
