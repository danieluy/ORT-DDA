package vista;

import controlador.ControladorMonitor;
import controlador.VistaMonitor;
import iu.MonitorAgenda;
import java.util.ArrayList;
import java.util.Observable;
import logica.Agenda;
import logica.Fachada;
import logica.Usuario;

public class MonitorUsuarios extends javax.swing.JDialog implements VistaMonitor {

    private ControladorMonitor controlador;

    public MonitorUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorMonitor(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 30, 400, 240);

        jLabel1.setText("DOBLRE CLICK PARA VER AGENDA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 300, 290, 20);

        setBounds(0, 0, 487, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        controlador.salir();
    }//GEN-LAST:event_formWindowClosing

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            controlador.abrirAgenda(lista.getSelectedIndex());
        }
    }//GEN-LAST:event_listaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    // End of variables declaration//GEN-END:variables

    private String formatear(Usuario u) {
        return u.getNombreCompleto() + " - " + u.getAgenda().getContactos().size() + " contacto(s)";
    }

    @Override
    public void mostrarUsuarios(ArrayList<Usuario> logueados) {
        ArrayList<String> listado = new ArrayList();
        for (Usuario u : logueados) {
            listado.add(formatear(u));
        }
        lista.setListData(listado.toArray());

    }

    @Override
    public void mostrarAgenda(Agenda a) {
        new MonitorAgenda(null, false, a).setVisible(true);
    }
}
