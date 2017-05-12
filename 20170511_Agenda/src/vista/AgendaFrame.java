package vista;

import controlador.AgendaControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.AgendaException;
import logica.Contacto;
import logica.Fachada;
import logica.Telefono;
import logica.Tipo;
import logica.Usuario;

public class AgendaFrame extends javax.swing.JFrame implements AgendaVista {
    
    private AgendaControlador controlador;
    
    public AgendaFrame(Usuario u) {
        initComponents();
        setLocationRelativeTo(null);
        controlador = new AgendaControlador(this, u.getAgenda());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tipos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        telefonos = new javax.swing.JList();
        agregarTelefono = new javax.swing.JButton();
        crearContacto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactos = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 30);
        getContentPane().add(nombre);
        nombre.setBounds(80, 20, 170, 30);

        jLabel2.setText("Numero");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 60, 30);
        getContentPane().add(numero);
        numero.setBounds(80, 100, 170, 30);

        jLabel3.setText("Tipo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 150, 40, 30);

        getContentPane().add(tipos);
        tipos.setBounds(80, 150, 170, 30);

        jScrollPane1.setViewportView(telefonos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 200, 170, 150);

        agregarTelefono.setText("Agregar");
        agregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(agregarTelefono);
        agregarTelefono.setBounds(270, 150, 90, 30);

        crearContacto.setText("Crear contacto");
        crearContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearContactoActionPerformed(evt);
            }
        });
        getContentPane().add(crearContacto);
        crearContacto.setBounds(100, 360, 130, 40);

        jScrollPane2.setViewportView(contactos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 50, 180, 300);

        jLabel4.setText("Contactos");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(430, 10, 80, 30);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(420, 360, 110, 40);

        setBounds(0, 0, 614, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTelefonoActionPerformed
        controlador.agregarTelefono(numero.getText(), (Tipo) tipos.getSelectedItem());
    }//GEN-LAST:event_agregarTelefonoActionPerformed


    private void crearContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearContactoActionPerformed
        controlador.crearContacto(nombre.getText());
    }//GEN-LAST:event_crearContactoActionPerformed
    
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        salir();
    }//GEN-LAST:event_salirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarTelefono;
    private javax.swing.JList contactos;
    private javax.swing.JButton crearContacto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField numero;
    private javax.swing.JButton salir;
    private javax.swing.JList telefonos;
    private javax.swing.JComboBox<Tipo> tipos;
    // End of variables declaration//GEN-END:variables

    
    private void salir() {
        controlador.salir();
        dispose();
    }
    
    @Override
    public void mostratTiposTelefono(ArrayList<Tipo> listaTipos) {
        for (Tipo t : listaTipos) {
            tipos.addItem(t);
        }
    }
    
    @Override
    public void mostrarDueno(String nombreCompleto) {
        setTitle(nombreCompleto);
    }
    
    @Override
    public void mostrarContactos(ArrayList<Contacto> contactos) {
        this.contactos.setListData(contactos.toArray());
    }
    
    @Override
    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    @Override
    public void mostrarTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos.setListData(telefonos.toArray());
    }

    @Override
    public void limpiarNombre() {
         nombre.setText("");
    }
}
