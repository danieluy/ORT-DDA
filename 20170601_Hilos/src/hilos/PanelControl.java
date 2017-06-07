package hilos;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PanelControl extends javax.swing.JFrame implements Observer {

  private int cont = 1;
  private ArrayList<ProcesoX> lista = new ArrayList();
  private ProcesoX seleccionado;

  public PanelControl() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crear = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProcesos = new javax.swing.JList();
        continuar = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        terminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        crear.setText("CREAR");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        getContentPane().add(crear);
        crear.setBounds(100, 40, 150, 50);

        parar.setText("DETENER");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        getContentPane().add(parar);
        parar.setBounds(100, 130, 150, 50);

        listaProcesos.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        listaProcesos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProcesosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaProcesos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 40, 420, 400);

        continuar.setText("CONTINUAR");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });
        getContentPane().add(continuar);
        continuar.setBounds(100, 210, 150, 50);

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(100, 280, 150, 60);

        terminar.setText("TERMINAR");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });
        getContentPane().add(terminar);
        terminar.setBounds(100, 370, 150, 70);

        setBounds(0, 0, 734, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
      ProcesoX p = new ProcesoX("P" + cont);
      cont++;
      p.addObserver(this);
      lista.add(p);
      p.mostrar();
    }//GEN-LAST:event_crearActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
      if (seleccionado != null)
        seleccionado.detener();
    }//GEN-LAST:event_pararActionPerformed

//    Seleccion de la lista
    private void listaProcesosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProcesosValueChanged
      ProcesoX tmp = (ProcesoX) listaProcesos.getSelectedValue();
      if (tmp != null)
        seleccionado = tmp;
    }//GEN-LAST:event_listaProcesosValueChanged

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
      if (seleccionado != null)
        seleccionado.continuar();
    }//GEN-LAST:event_continuarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
      if (seleccionado != null)
        seleccionado.reset();
    }//GEN-LAST:event_resetActionPerformed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
      if (seleccionado != null)
        seleccionado.terminar();
    }//GEN-LAST:event_terminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JButton crear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaProcesos;
    private javax.swing.JButton parar;
    private javax.swing.JButton reset;
    private javax.swing.JButton terminar;
    // End of variables declaration//GEN-END:variables

  private void mostrar() {
    listaProcesos.setListData(lista.toArray());
  }

  @Override
  public void update(Observable o, Object evento) {
    if (evento.equals(ProcesoX.Eventos.estado) || evento.equals(ProcesoX.Eventos.valor))
      mostrar();
  }
}
