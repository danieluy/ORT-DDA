package logica;

import java.util.ArrayList;

public class SistemaAgenda {

    private ArrayList<Tipo> tipos = new ArrayList();
    private ArrayList<Agenda> agendas = new ArrayList();

    public void agregar(Tipo t) {
        tipos.add(t);
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public Agenda getAgenda() {
        Usuario logueado = Fachada.getInstancia().getLogueado();
        Agenda agenda = null;
        if (logueado != null) {
            for (Agenda a : agendas) {
                if (a.getDueño() == logueado) {
                    agenda = a;
                }
            }
            if (agenda == null) {
                //es el primer login
                agenda = new Agenda(logueado);
                agendas.add(agenda);
            }
        }
        return agenda;
    }

}
