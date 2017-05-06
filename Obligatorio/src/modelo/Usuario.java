package modelo;

public class Usuario {

    private String nombre;
    private String password;
    private String nombreCompleto;

    public Usuario(String nombre, String nombreCompleto, String password) {
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
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

    public void validar() throws UsuarioException {
        if (nombre.isEmpty() || password.isEmpty() || nombreCompleto.isEmpty()) {
            throw new UsuarioException("Error creando un usuario");
        }
    }

}
