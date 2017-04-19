package logica;

import java.util.ArrayList;

public class Tipo {
    private String nombre;
    private ArrayList<Telefono> telefonos = new ArrayList();

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarTelefono(Telefono t){
        telefonos.add(t);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
