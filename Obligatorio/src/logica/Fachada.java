package logica;

public class Fachada {

    private Fachada fachada;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaPartidas sistemaPartidas;

    private Fachada() {
        sistemaUsuarios = new SistemaUsuarios();
        sistemaPartidas = new SistemaPartidas();
    }

    public Fachada getInstancia() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

}
