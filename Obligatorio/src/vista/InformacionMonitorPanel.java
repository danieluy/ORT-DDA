package vista;

import controlador.PartidaControlador;
import java.awt.event.ActionListener;

public class InformacionMonitorPanel extends javax.swing.JPanel {

  private PartidaControlador controlador;

  public InformacionMonitorPanel(String tituloPartida, String pozo, String numeroTurno, String turnoDe) {
    initComponents();
    this.controlador = controlador;
    lbl_titulo.setText(tituloPartida);
    lbl_pozo.setText(pozo);
    lbl_numeroTurno.setText(numeroTurno);
    lbl_turnoDe.setText(turnoDe);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    lbl_pozo = new javax.swing.JLabel();
    lbl_titulo = new javax.swing.JLabel();
    lbl_numeroTurno = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    lbl_turnoDe = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(400, 150));
    setMinimumSize(new java.awt.Dimension(400, 150));
    setPreferredSize(new java.awt.Dimension(400, 150));

    jLabel1.setText("Pozo");

    lbl_pozo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_pozo.setText("$0");

    lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_titulo.setText("Jugador 1 vs. Jugador 2");

    lbl_numeroTurno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_numeroTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lbl_numeroTurno.setText("#1");

    jLabel3.setText("Turno");

    jLabel2.setText("Juega");

    lbl_turnoDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lbl_turnoDe.setText("Jugador");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(lbl_pozo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lbl_numeroTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lbl_turnoDe, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_pozo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_numeroTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lbl_turnoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(13, Short.MAX_VALUE))
    );

    lbl_pozo.getAccessibleContext().setAccessibleName("lbl_jugador");
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel lbl_numeroTurno;
  private javax.swing.JLabel lbl_pozo;
  private javax.swing.JLabel lbl_titulo;
  private javax.swing.JLabel lbl_turnoDe;
  // End of variables declaration//GEN-END:variables
}
