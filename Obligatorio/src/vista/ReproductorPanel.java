package vista;

import controlador.MonitorControlador;

public class ReproductorPanel extends javax.swing.JPanel {

  private MonitorControlador controlador;

  public ReproductorPanel(MonitorControlador controlador) {
    initComponents();
    this.controlador = controlador;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btn_adelante = new javax.swing.JButton();
    btn_atras = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(100, 550));
    setMinimumSize(new java.awt.Dimension(100, 550));
    setPreferredSize(new java.awt.Dimension(100, 550));

    btn_adelante.setText("Adelante");
    btn_adelante.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_adelanteActionPerformed(evt);
      }
    });

    btn_atras.setText("Atrás");
    btn_atras.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_atrasActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(btn_adelante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btn_atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(15, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btn_adelante, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(413, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void btn_adelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adelanteActionPerformed
    controlador.adelante();
  }//GEN-LAST:event_btn_adelanteActionPerformed

  private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
    controlador.atras();
  }//GEN-LAST:event_btn_atrasActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btn_adelante;
  private javax.swing.JButton btn_atras;
  // End of variables declaration//GEN-END:variables
}
