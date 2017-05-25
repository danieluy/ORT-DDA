package vista;

import controlador.PartidaControlador;

public class PartidaInformacionPanel extends javax.swing.JPanel {

  private PartidaControlador controlador;

  public PartidaInformacionPanel(PartidaControlador controlador, String tituloPartida, String turno, String saldo, String pozo, String apuestaActual, String numeroTurno) {
    initComponents();
    this.controlador = controlador;
    lbl_titulo.setText(tituloPartida);
    lbl_jugadorTurno.setText(turno);
    lbl_saldo.setText(saldo);
    lbl_pozo.setText(pozo);
    lbl_numeroTurno.setText(numeroTurno);
    lbl_totalApuesta.setText(apuestaActual);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    lbl_pozo = new javax.swing.JLabel();
    lbl_jugador1 = new javax.swing.JLabel();
    lbl_titulo = new javax.swing.JLabel();
    lbl_jugadorTurno = new javax.swing.JLabel();
    lbl_saldo = new javax.swing.JLabel();
    lbl_numeroTurno = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    txt_montoApuesta = new javax.swing.JTextField();
    btn_apostar = new javax.swing.JButton();
    btn_pagar = new javax.swing.JButton();
    btn_subir = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    lbl_totalApuesta = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(400, 150));
    setMinimumSize(new java.awt.Dimension(400, 150));
    setPreferredSize(new java.awt.Dimension(400, 150));

    jLabel1.setText("Pozo");

    lbl_pozo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_pozo.setText("$0");

    lbl_jugador1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lbl_jugador1.setText("Tu saldo es de");

    lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_titulo.setText("Jugador 1 vs. Jugador 2");

    lbl_jugadorTurno.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    lbl_jugadorTurno.setText("Juega tu oponente");

    lbl_saldo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    lbl_saldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbl_saldo.setText("$0");

    lbl_numeroTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_numeroTurno.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbl_numeroTurno.setText("#1");

    jLabel3.setText("Turno");

    txt_montoApuesta.setPreferredSize(null);

    btn_apostar.setText("Apostar");
    btn_apostar.setPreferredSize(null);
    btn_apostar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_apostarActionPerformed(evt);
      }
    });

    btn_pagar.setText("Pagar");
    btn_pagar.setPreferredSize(null);
    btn_pagar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_pagarActionPerformed(evt);
      }
    });

    btn_subir.setText("Subir");
    btn_subir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_subirActionPerformed(evt);
      }
    });

    jLabel2.setText("Total apuesta");
    jLabel2.setPreferredSize(null);

    lbl_totalApuesta.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
    lbl_totalApuesta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbl_totalApuesta.setText("$0");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_pozo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(lbl_jugadorTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(btn_apostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_subir)
                .addGap(18, 18, 18)
                .addComponent(txt_montoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(lbl_jugador1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(lbl_numeroTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(lbl_saldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_totalApuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lbl_jugadorTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_pozo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_numeroTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txt_montoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btn_apostar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btn_subir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_totalApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(9, Short.MAX_VALUE))
    );

    lbl_pozo.getAccessibleContext().setAccessibleName("lbl_jugador");
  }// </editor-fold>//GEN-END:initComponents

    private void btn_apostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apostarActionPerformed
      controlador.apostar(txt_montoApuesta.getText());
    }//GEN-LAST:event_btn_apostarActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
      controlador.pagar();
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void btn_subirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subirActionPerformed
      controlador.subir(txt_montoApuesta.getText());
    }//GEN-LAST:event_btn_subirActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btn_apostar;
  private javax.swing.JButton btn_pagar;
  private javax.swing.JButton btn_subir;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel lbl_jugador1;
  private javax.swing.JLabel lbl_jugadorTurno;
  private javax.swing.JLabel lbl_numeroTurno;
  private javax.swing.JLabel lbl_pozo;
  private javax.swing.JLabel lbl_saldo;
  private javax.swing.JLabel lbl_titulo;
  private javax.swing.JLabel lbl_totalApuesta;
  private javax.swing.JTextField txt_montoApuesta;
  // End of variables declaration//GEN-END:variables
}
