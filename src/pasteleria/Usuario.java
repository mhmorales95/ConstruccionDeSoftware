/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class Usuario extends javax.swing.JDialog {

    /**
     * Creates new form Usuario
     */
    public Usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarUsuarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contrasena = new javax.swing.JPasswordField();
        usuario = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(contrasena);
        contrasena.setBounds(150, 166, 130, 22);

        usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione usuario..." }));
        usuario.setBorder(null);
        usuario.setMaximumSize(new java.awt.Dimension(130, 20));
        usuario.setName(""); // NOI18N
        usuario.setPreferredSize(new java.awt.Dimension(130, 20));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });
        getContentPane().add(usuario);
        usuario.setBounds(150, 112, 130, 22);

        jButton1.setText("Entrar");
        getContentPane().add(jButton1);
        jButton1.setBounds(112, 208, 184, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Login.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        
    }//GEN-LAST:event_usuarioActionPerformed

    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        contrasena.requestFocus();
    }//GEN-LAST:event_usuarioKeyTyped

    private void cargarUsuarios() {
        if (true) {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;

            try {
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios");
                String s = String.valueOf(contrasena.getPassword());
                
                ResultSet rs;
                rs = stmt.executeQuery();
                boolean r = rs.next();
                 
                    while (r) {
                        String n = rs.getString("nombre");
                        usuario.addItem(n);
                    

                        r = rs.next();

                    }

                

            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> usuario;
    // End of variables declaration//GEN-END:variables
}
