/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class Configuracion extends javax.swing.JFrame {
    
    public int insertar = 0;

    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        usuariocod = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        usunombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        usucon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        accesoTotal = new javax.swing.JRadioButton();
        accesoPedido = new javax.swing.JRadioButton();
        accesoCaja = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        editarFamtxt = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        familiaEliminar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Codigo usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        usuariocod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariocodActionPerformed(evt);
            }
        });
        getContentPane().add(usuariocod, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 80, -1));

        jButton4.setText("Cargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));
        getContentPane().add(usunombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 154, -1));

        jLabel6.setText("Nombre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 50, -1));
        getContentPane().add(usucon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 154, -1));

        jLabel7.setText("Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        accesoTotal.setText("Acceso Total");
        getContentPane().add(accesoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        accesoPedido.setText("Acceso a pedido");
        accesoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesoPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(accesoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        accesoCaja.setText("Acceso a caja");
        getContentPane().add(accesoCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jButton3.setText("Eliminar Usuario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, -1, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 120, -1));

        jButton5.setText("Crear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 90, -1));

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 90, -1));
        getContentPane().add(editarFamtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 110, -1));

        jButton7.setText("Editar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 80, -1));

        jLabel1.setText("Familias:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 60, 20));

        familiaEliminar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        familiaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familiaEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(familiaEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoConfiguraciones.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(1024, 700));
        jLabel2.setMinimumSize(new java.awt.Dimension(1024, 700));
        jLabel2.setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuariocodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariocodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariocodActionPerformed
    
    public void cargar() {
        
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        
        try {
            sql = con.createStatement();
            
            ResultSet rs = sql.executeQuery("SELECT * FROM familias");
            System.out.println("CONSULTA EJECUTADA");
            
            boolean r = rs.next();
            while (r) {
                
                familiaEliminar.addItem(rs.getString("nombre"));
                
                r = rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (usuariocod.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No ha ingresado codigo usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;
            try {
                sql = con.createStatement();
                
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuarios WHERE codigo = ?");
                stmt.setInt(1, Integer.parseInt(usuariocod.getText()));
                
                ResultSet rs;
                rs = stmt.executeQuery();
                
                boolean r = rs.next();
                if (r == false) {
                    JOptionPane.showMessageDialog(this, "Se creará usuario", "", JOptionPane.INFORMATION_MESSAGE);
                    usunombre.setText("");
                    usucon.setText("");
                    accesoTotal.setSelected(false);
                    accesoPedido.setSelected(false);
                    accesoCaja.setSelected(false);
                    insertar = 1;
                }
                while (r) {
                    
                    usunombre.setText(rs.getString("nombre"));
                    usucon.setText(rs.getString("contrasena"));
                    if (rs.getInt("accesoCaja") == 1) {
                        accesoCaja.setSelected(true);
                    } else {
                        accesoCaja.setSelected(false);
                    }
                    if (rs.getInt("accesoTotal") == 1) {
                        accesoTotal.setSelected(true);
                    } else {
                        accesoTotal.setSelected(false);
                    }
                    if (rs.getInt("accesoPedido") == 1) {
                        accesoPedido.setSelected(true);
                    } else {
                        accesoPedido.setSelected(false);
                    }
                    
                    r = rs.next();
                    insertar = 0;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void accesoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accesoPedidoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (usuariocod.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No ha ingresado codigo usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;
            try {
                System.out.println("aqui");
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("DELETE FROM usuarios WHERE codigo = ?");
                stmt.setInt(1, Integer.parseInt(usuariocod.getText()));
                usunombre.setText("");
                usucon.setText("");
                accesoTotal.setSelected(false);
                accesoPedido.setSelected(false);
                accesoCaja.setSelected(false);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Usuario Borrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (usuariocod.getText().equals("") || usunombre.getText().equals("") || usucon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Datos faltantes", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
            if (insertar == 1) {
                MySQL my = new MySQL();
                Connection con = my.getConnection();
                Statement sql;
                try {
                    System.out.println("aqui");
                    sql = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO usuarios"
                            + " (codigo, nombre, contrasena, accesoCaja,accesoTotal,accesoPedido) VALUES (?,?,?,?,?,?);");
                    stmt.setInt(1, Integer.parseInt(usuariocod.getText()));
                    stmt.setString(2, usunombre.getText());
                    stmt.setString(3, usucon.getText());
                    if (accesoCaja.isSelected()) {
                        stmt.setInt(4, 1);
                    } else {
                        stmt.setInt(4, 0);
                    }
                    if (accesoTotal.isSelected()) {
                        stmt.setInt(5, 1);
                    } else {
                        stmt.setInt(5, 0);
                    }
                    if (accesoPedido.isSelected()) {
                        stmt.setInt(6, 1);
                    } else {
                        stmt.setInt(6, 0);
                    }
                    
                    insertar = 0;
                    stmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Usuario añadido", "Información", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                
                MySQL my = new MySQL();
                Connection con = my.getConnection();
                Statement sql;
                try {
                    System.out.println("aqui");
                    sql = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("UPDATE usuarios SET nombre = ?,contrasena = ?,accesoCaja = ?,accesoTotal = ?,"
                            + "accesoPedido = ? WHERE codigo = ?;");
                    
                    stmt.setString(1, usunombre.getText());
                    stmt.setString(2, usucon.getText());
                    if (accesoCaja.isSelected()) {
                        stmt.setInt(3, 1);
                    } else {
                        stmt.setInt(3, 0);
                    }
                    
                    if (accesoTotal.isSelected()) {
                        stmt.setInt(4, 1);
                    } else {
                        stmt.setInt(4, 0);
                    }
                    if (accesoPedido.isSelected()) {
                        stmt.setInt(5, 1);
                    } else {
                        stmt.setInt(5, 0);
                    }
                    
                    stmt.setInt(6, Integer.parseInt(usuariocod.getText()));
                    insertar = 0;
                    stmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Usuario modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }

        //
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO familias"
                    + " (nombre) VALUES (?);");

            // stmt.setInt(1, familiaMayor);
            stmt.setString(1, jTextField3.getText());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Familia creada!", "Información", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        familiaEliminar.removeAllItems();
        familiaEliminar.addItem("Seleccionar");
        jTextField3.setText("");
        cargar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM familias WHERE nombre = ? ");
            
            stmt.setString(1, (String) familiaEliminar.getSelectedItem());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Familia eliminada!", "Información", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        familiaEliminar.removeAllItems();
        familiaEliminar.addItem("Seleccionar");
        cargar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            System.out.println("aqui");
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("UPDATE `familias` SET nombre = ?"
                    + " WHERE nombre = ?;");
            
            stmt.setString(1, editarFamtxt.getText());
            stmt.setString(2, (String) familiaEliminar.getSelectedItem());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println("aqui");
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("UPDATE `productos` SET familia = ?"
                    + " WHERE familia = ?;");
            
            stmt.setString(1, editarFamtxt.getText());
            stmt.setString(2, (String) familiaEliminar.getSelectedItem());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("aqui");
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("UPDATE `subfamilias` SET familia = ?"
                    + " WHERE familia = ?;");
            
            stmt.setString(1, editarFamtxt.getText());
            stmt.setString(2, (String) familiaEliminar.getSelectedItem());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(this, "Familia editada!", "Información", JOptionPane.INFORMATION_MESSAGE);
        familiaEliminar.removeAllItems();
        familiaEliminar.addItem("Seleccionar");
        jTextField3.setText("");
        cargar();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void familiaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familiaEliminarActionPerformed
        editarFamtxt.setText((String) familiaEliminar.getSelectedItem());
    }//GEN-LAST:event_familiaEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton accesoCaja;
    private javax.swing.JRadioButton accesoPedido;
    private javax.swing.JRadioButton accesoTotal;
    private javax.swing.JTextField editarFamtxt;
    private javax.swing.JComboBox<String> familiaEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField usuariocod;
    private javax.swing.JTextField usucon;
    private javax.swing.JTextField usunombre;
    // End of variables declaration//GEN-END:variables
}
