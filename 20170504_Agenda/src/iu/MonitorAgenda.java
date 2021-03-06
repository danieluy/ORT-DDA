/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.util.Observable;
import java.util.Observer;
import logica.Agenda;

/**
 *
 * @author docenteFI
 */
public class MonitorAgenda extends javax.swing.JDialog implements Observer{

    /**
     * Creates new form MonitorAgenda
     */
    private Agenda agenda;
    public MonitorAgenda(java.awt.Frame parent, boolean modal,Agenda a) {
        super(parent, modal);
        initComponents();
        agenda = a;
        agenda.addObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaContactos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(listaContactos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 380, 260);

        setBounds(0, 0, 459, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        agenda.deleteObserver(this);
    }//GEN-LAST:event_formWindowClosing

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaContactos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object evento) {
        if(evento.equals(Agenda.Eventos.contactos)){
            mostrar();
        }
    }

    private void mostrar() {
        listaContactos.setListData(agenda.getContactos().toArray());
    }
}
