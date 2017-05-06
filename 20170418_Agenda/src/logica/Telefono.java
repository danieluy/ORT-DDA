package logica;

public class Telefono {

    private String numero;
    private Tipo tipo;
    private Contacto contacto;

    public Telefono(String numero, Tipo tipo, Contacto contacto) {
        this.numero = numero;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public void validar() throws AgendaException {
        if (numero == null || numero.length() < 6) {
            throw new AgendaException("Número incorecto");
        }
        if (tipo == null) {
            throw new AgendaException("Falta el tipo");
        }
    }

    @Override
    public String toString() {
        return numero + " - (" + tipo.getNombre() + ")";
    }

    @Override
    public boolean equals(Object o) {
        Telefono t = (Telefono) o;
        return t.numero.equals(numero);
    }

    public Contacto getContacto() {
        return contacto;
    }

}
