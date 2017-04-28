package iu;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import logica.Agenda;
import logica.Fachada;
import logica.Usuario;

public class MonitorUsuarios extends javax.swing.JFrame implements Observer {

    private Fachada logica = Fachada.getInstancia();
    private ArrayList<Usuario> logueados = new ArrayList();

    public MonitorUsuarios() {
        initComponents();
        logica.addObserver(this);
        mostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        listaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void listaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUsuariosMouseClicked
        if (evt.getClickCount() == 2) {
            mostrarAgenda();
        }
    }//GEN-LAST:event_listaUsuariosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logica.deleteObserver(this);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaUsuarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable origen, Object evento) {
        if (evento.equals(Fachada.Eventos.listaLogueados) || evento.equals(Fachada.Eventos.listaContactos)) {
            mostrar();
        }
    }

    private void mostrar() {
//        clonamos la lista para que no nos afecten cambios de la lógica cuando vamos a seleccionar un usuario de la lista
        logueados = new ArrayList(logica.getLogueados());
        ArrayList<String> listado = new ArrayList();
        for (Usuario u : logueados) {
            listado.add(formatear(u));
        }
        listaUsuarios.setListData(listado.toArray());
    }

    private String formatear(Usuario u) {
        int contactos = u.getAgenda().getContactos().size();
        return u.getNombreCompleto() + " - " + contactos + (contactos == 1 ? " contacto" : " contactos");
    }

    private void mostrarAgenda() {
        int pos = listaUsuarios.getSelectedIndex();
        if (pos != -1) {
            Agenda a = logueados.get(pos).getAgenda();
            new MonitorAgenda(this, false, a).setVisible(true);
        }
    }
}
