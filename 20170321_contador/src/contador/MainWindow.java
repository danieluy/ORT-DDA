package contador;

public class MainWindow extends javax.swing.JFrame {

    private Contador counter = new Contador();

    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
        updateView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_output = new javax.swing.JTextField();
        btn_plus = new javax.swing.JButton();
        btn_minus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        txt_output.setEditable(false);
        txt_output.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txt_output.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_output);
        txt_output.setBounds(130, 50, 140, 130);

        btn_plus.setBackground(new java.awt.Color(255, 255, 255));
        btn_plus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_plus.setForeground(new java.awt.Color(102, 102, 102));
        btn_plus.setText("+");
        btn_plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_plus);
        btn_plus.setBounds(130, 180, 70, 70);

        btn_minus.setBackground(new java.awt.Color(255, 255, 255));
        btn_minus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_minus.setForeground(new java.awt.Color(102, 102, 102));
        btn_minus.setText("-");
        btn_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_minus);
        btn_minus.setBounds(200, 180, 70, 70);

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents


    private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plusActionPerformed
        counter.plus();
        updateView();
    }//GEN-LAST:event_btn_plusActionPerformed

    private void btn_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minusActionPerformed
        counter.minus();
        updateView();
    }//GEN-LAST:event_btn_minusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_minus;
    private javax.swing.JButton btn_plus;
    private javax.swing.JTextField txt_output;
    // End of variables declaration//GEN-END:variables

    private void updateView() {
        txt_output.setText("" + counter.getValue());
    }
}
