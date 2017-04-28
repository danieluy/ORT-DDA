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

    public void asignarAgenda(Usuario u) {
        Agenda agenda = u.getAgenda();
        if (agenda == null) {
            //es el primer login
            agenda = new Agenda(u);
            agendas.add(agenda);
        }
    }
}
