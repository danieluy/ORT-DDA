package vistas;

import vistas.login.LoginFrame;

public class InicioFrame extends javax.swing.JFrame {

    public enum tipoUsuario {
        jugador, administrador
    }

    public InicioFrame() {
        initComponents();
        setTitle("Buscaminas");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_jugador = new javax.swing.JButton();
        btn_administrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_jugador.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_jugador.setText("Jugar");
        btn_jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jugadorActionPerformed(evt);
            }
        });

        btn_administrador.setText("Administrador");
        btn_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_administradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_jugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(btn_administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btn_administrador)
                .addContainerGap())
        );

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_jugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jugadorActionPerformed
        new LoginFrame(tipoUsuario.jugador).setVisible(true);
    }//GEN-LAST:event_btn_jugadorActionPerformed

    private void btn_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_administradorActionPerformed
        new LoginFrame(tipoUsuario.administrador).setVisible(true);
    }//GEN-LAST:event_btn_administradorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO varificar si no hay juegos activos
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_administrador;
    private javax.swing.JButton btn_jugador;
    // End of variables declaration//GEN-END:variables
}
