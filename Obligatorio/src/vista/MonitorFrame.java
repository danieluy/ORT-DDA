package vista;

import controlador.MonitorControlador;
import controlador.MonitorVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import modelo.Partida;

public class MonitorFrame extends javax.swing.JFrame implements MonitorVista {

  private MonitorControlador controlador;
  private Partida partida;
  private JSplitPane splitGeneral;
  private JSplitPane splitTableroInfo;

  MonitorFrame(Partida partida) {
    initComponents();
    controlador = new MonitorControlador(this, partida);
    iniciarReproductor();
  }

  private void iniciarReproductor() {
    splitGeneral = new JSplitPane();
    splitGeneral.setDividerLocation(50);
    splitGeneral.setDividerSize(0);

    splitTableroInfo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitTableroInfo.setDividerLocation(150);
    splitTableroInfo.setDividerSize(0);

    splitGeneral.setTopComponent(new ReproductorPanel(controlador));
    splitGeneral.setBottomComponent(splitTableroInfo);

    setContentPane(splitGeneral);
    controlador.actualizarVista();
  }

  @Override
  public void mostrarTablero(int tamano, ArrayList casilleros) {
    TableroPanel panelTablero = new TableroPanel();
    splitTableroInfo.setBottomComponent(panelTablero);
    panelTablero.mostrarTablero(tamano, casilleros, null);
    validate();
  }

  @Override
  public void mostrarDatos(String tituloPartida, double pozo, int numeroTurno, String turnoDe) {
    InformacionMonitorPanel infoPanel = new InformacionMonitorPanel(tituloPartida, ("$" + pozo), ("#" + numeroTurno), turnoDe);
    splitTableroInfo.setTopComponent(infoPanel);
    validate();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
