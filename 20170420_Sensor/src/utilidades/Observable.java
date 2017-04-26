package utilidades;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList<Observador> observadores = new ArrayList();

    public void agregar(Observador obs) {
        if (!observadores.contains(obs)) {
            observadores.add(obs);
        }
    }

    public void quitar(Observador obs) {
        observadores.remove(obs);
    }

    public void avisar(Object evento) {
        for (Observador obs : observadores) {
            obs.actualizar(evento, this);
        }
    }

}
