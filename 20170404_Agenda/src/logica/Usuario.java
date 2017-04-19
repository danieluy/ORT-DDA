package logica;

public class Usuario {
    
    private String nombre;
    private String password;
    private String nombreCompleto;

    public Usuario(String nombre, String password, String nombreCompleto) {
        this.nombre = nombre;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
}
