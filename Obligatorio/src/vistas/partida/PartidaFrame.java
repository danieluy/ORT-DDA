package vistas.partida;

import controladores.PartidaControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import modelo.Jugador;

public class PartidaFrame extends javax.swing.JFrame implements PartidaVista, ActionListener {

    private PartidaControlador controlador;
    private JSplitPane splitPane;

    public PartidaFrame(Jugador jugador) {
        initComponents();
        controlador = new PartidaControlador(this);
        controlador.crearPartida(jugador);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_tamano = new javax.swing.JTextField();
        btn_tamano = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_titulo.setText("Partida");

        jLabel1.setText("Tamaño del tablero:");

        btn_tamano.setText("Guardar");
        btn_tamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tamanoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel2.setText("* El tamaño de tablero representa la cantidad de casilleros a cada lado del tablero.");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tamano)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tamano, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tamano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_tamano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("lbl_tamano");
        jLabel2.getAccessibleContext().setAccessibleName("lbl_notaAlPie");

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

  private void btn_tamanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamanoActionPerformed
      controlador.setTamanoTablero(txt_tamano.getText());
  }//GEN-LAST:event_btn_tamanoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tamano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_tamano;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTitulo(String titulo) {
        setTitle(titulo);
        lbl_titulo.setText(titulo);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @Override
    public void iniciarTablero() {
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(new InfoPanel());
        splitPane.setDividerLocation(150);
        setContentPane(splitPane);
    }

    @Override
    public void mostrarTablero(int tamano, ArrayList casilleros) {
        PanelTablero panelTablero = new PanelTablero();
        panelTablero.mostrarTablero(tamano, casilleros, this);
        splitPane.setBottomComponent(panelTablero);
        validate();
    }

    @Override
    public void mostrarEspera(String mensaje) {
        JPanel esperandoPanel = new JPanel();
        JLabel esperandoLabel = new JLabel(mensaje);
        esperandoPanel.add(esperandoLabel);
        setContentPane(esperandoPanel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        BotonCasillero boton = (BotonCasillero) evt.getSource();
        CasilleroPanel casillero = boton.getCasillero();
        controlador.destapar(casillero);
    }

}
