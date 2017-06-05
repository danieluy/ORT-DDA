package vista;

import controlador.MonitorControlador;
import controlador.MonitorVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import modelo.Partida;

public class MonitorFrame extends javax.swing.JFrame implements MonitorVista {

  private MonitorControlador controlador;
  private JSplitPane splitGeneral;
  private JSplitPane splitTableroInfo;

  public MonitorFrame(Partida partida) throws VistaException {
    if (!partida.haIniciado())
      throw new VistaException("Partida no iniciada");
    initComponents();
    controlador = new MonitorControlador(this, partida);
    iniciarReproductor();
  }

  private void iniciarReproductor() {
    splitGeneral = new JSplitPane();
    splitGeneral.setDividerLocation(100);
    splitGeneral.setDividerSize(0);
    splitGeneral.setSize(500, 550);

    splitTableroInfo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitTableroInfo.setDividerLocation(150);
    splitTableroInfo.setDividerSize(0);
    splitTableroInfo.setSize(400, 550);

    ReproductorPanel reproductorPanel = new ReproductorPanel(controlador);
    reproductorPanel.setSize(100, 550);
    splitGeneral.setTopComponent(reproductorPanel);
    splitGeneral.setBottomComponent(splitTableroInfo);

    setContentPane(splitGeneral);
    controlador.actualizarVista();
  }

  @Override
  public void mostrarTablero(int tamano, ArrayList casilleros) {
    TableroPanel panelTablero = new TableroPanel();
    panelTablero.setSize(400, 400);
    splitTableroInfo.setBottomComponent(panelTablero);
    panelTablero.mostrarTablero(tamano, casilleros, null);
    validate();
  }

  @Override
  public void mostrarDatos(String tituloPartida, double pozo, int numeroTurno, String turnoDe) {
    MonitorInformacionPanel infoPanel = new MonitorInformacionPanel(tituloPartida, ("$" + pozo), ("#" + numeroTurno), turnoDe);
    infoPanel.setSize(400, 150);
    splitTableroInfo.setTopComponent(infoPanel);
    validate();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setMaximumSize(new java.awt.Dimension(500, 550));
    setMinimumSize(new java.awt.Dimension(500, 550));
    setPreferredSize(new java.awt.Dimension(500, 550));
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    controlador.salir();
  }//GEN-LAST:event_formWindowClosing

  @Override
  public void mostrarError(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
