package vista;

import controlador.ListaPartidaVista;
import controlador.ListaPartidasControlador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Partida;

public class ListaPartidasFrame extends javax.swing.JFrame implements ListaPartidaVista {

  private ListaPartidasControlador controlador;

  public ListaPartidasFrame() {
    initComponents();
    controlador = new ListaPartidasControlador(this);
  }

  private void formWindowClosing(java.awt.event.WindowEvent evt) {
    controlador.salir();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    lista_partidas = new javax.swing.JList();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel1.setText("Lista de Partidas");

    lista_partidas.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lista_partidasMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(lista_partidas);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        .addContainerGap())
    );

    setBounds(0, 0, 416, 339);
  }// </editor-fold>//GEN-END:initComponents

  private void lista_partidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_partidasMouseClicked
    if (evt.getClickCount() == 2) {
      seleccionarPartida();
    }
  }//GEN-LAST:event_lista_partidasMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList lista_partidas;
  // End of variables declaration//GEN-END:variables

  private void seleccionarPartida() {
    int pos = lista_partidas.getSelectedIndex();
    if (pos != -1) {
      new MonitorFrame(controlador.getPartida(pos)).setVisible(true);
    }
  }

  @Override
  public void mostrarPartidas(ArrayList<String> partidas) {
    lista_partidas.setListData(partidas.toArray());
  }
}
