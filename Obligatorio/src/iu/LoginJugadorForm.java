package iu;

import javax.swing.JOptionPane;
import logica.Jugador;
import logica.Usuario;

public class LoginJugadorForm extends java.awt.Frame implements LoginVista {

    public LoginJugadorForm() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    @Override
    public void loginOk(Usuario usuario) {
        Jugador jugador = (Jugador) usuario;
        JOptionPane.showMessageDialog(this, jugador.getNombreCompleto() + " ha iniciado sesión");
     }

    @Override
    public void loginError(String mensage) {
        JOptionPane.showMessageDialog(this, mensage);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
