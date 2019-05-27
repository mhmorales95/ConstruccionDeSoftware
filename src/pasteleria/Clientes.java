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
public class Clientes extends javax.swing.JFrame {

    private boolean creado = false;

    public Clientes() {
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

        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        nombreCompleto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rut = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        codigoInicial = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 700));
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setPreferredSize(new java.awt.Dimension(1024, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(211, 80, 97));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setToolTipText("");
        jPanel6.setMaximumSize(new java.awt.Dimension(766, 226));
        jPanel6.setMinimumSize(new java.awt.Dimension(766, 226));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre completo:");

        nombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCompletoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("RUT: ");

        rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Código:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dirección:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Teléfono:");

        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 595, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(97, 97, 97))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jButton4.setBackground(new java.awt.Color(123, 101, 122));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Volver");
        jButton4.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 631, -1, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));
        getContentPane().add(codigoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 320, -1));

        jButton3.setText("Cargar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoClientes.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCompletoActionPerformed

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.borrarCampos();
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void actualizar() {

        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("UPDATE clientes SET rut = ?,nombre = ?,"
                    + " telefono = ?, direccion = ? WHERE codigo = ?;");
            if (!codigo.getText().equals("")) {
                stmt.setInt(5, Integer.parseInt(codigo.getText()));
            } else {
                System.out.println("Esta vacio el codigo");
            }

            if (!nombreCompleto.getText().equals("")) {
                stmt.setString(2, nombreCompleto.getText());
            } else {
                System.out.println("Esta vacío el nombre");
            }

            if (!rut.getText().equals("")) {
                stmt.setString(1, rut.getText());
            } else {
                System.out.println("RUT está vacío");
            }

            if (!telefono.getText().equals("")) {
                stmt.setString(3, telefono.getText());
            } else {
                System.out.println("Teléfono está vacío");
            }

            if (!direccion.getText().equals("")) {
                stmt.setString(4, direccion.getText());
            } else {
                System.out.println("Direccion vacia");
            }

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente modificado", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (creado) {
            actualizar();
        } else {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;
            if ((!nombreCompleto.getText().equals("")) && (!codigo.getText().equals("")) && (!rut.getText().equals(""))
                    && (!telefono.getText().equals("")) && (!direccion.getText().equals(""))) {
                try {
                    sql = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO clientes (codigo, rut,"
                            + "nombre, telefono, direccion)"
                            + " VALUES (?,?,?,?,?);");

                    if (!nombreCompleto.getText().equals("")) {
                        stmt.setString(3, nombreCompleto.getText());
                    } else {
                        System.out.println("Esta vacío el nombre");
                    }

                    if (!codigo.getText().equals("")) {
                        stmt.setInt(1, Integer.parseInt(codigo.getText()));
                    } else {
                        System.out.println("Esta vacio el codigo");
                    }

                    if (!rut.getText().equals("")) {
                        stmt.setString(2, rut.getText());
                    } else {
                        System.out.println("RUT está vacío");
                    }

                    if (!telefono.getText().equals("")) {
                        stmt.setString(4, telefono.getText());
                    } else {
                        System.out.println("Teléfono está vacío");
                    }

                    if (!direccion.getText().equals("")) {
                        stmt.setString(5, direccion.getText());
                    } else {
                        System.out.println("Direccion vacia");
                    }

                    stmt.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(this, "Cliente agregado", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.borrarCampos();

            } else {
                JOptionPane.showMessageDialog(this, "Es necesario rellenar todos los campos", "Campos incompletos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        creado = false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BusquedaCliente b = new BusquedaCliente(this, true);
        b.setVisible(true);

        nombreCompleto.setText(b.obtenerNombre());
        System.out.println("" + b.obtenerRut() + "+" + b.obtenerNombre());
        rut.setText(b.obtenerRut());
        codigo.setText(b.obtenerCodigo());
        direccion.setText(b.obtenerDireccion());
        telefono.setText("" + b.obtenerDescuento());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.llamarCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    private void borrarCampos() {
        this.telefono.setText("");
        this.nombreCompleto.setText("");
        this.rut.setText("");
        this.codigo.setText("");
        this.direccion.setText("");
    }

    public void llamarCliente() {
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        String cod = codigoInicial.getText();

        try {
            sql = con.createStatement();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes WHERE codigo = ? ");
            stmt.setString(1, cod);
            ResultSet rs;
            rs = stmt.executeQuery();

            boolean r = rs.next();
            System.out.println(r);
            if (r == false) {
                JOptionPane.showMessageDialog(this, "Se creará nuevo cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.borrarCampos();
            }
            while (r) {
                creado = true;
                nombreCompleto.setText(rs.getString("nombre"));
                rut.setText(rs.getString("rut"));
                codigo.setText("" + rs.getInt("codigo"));
                direccion.setText(rs.getString("direccion"));
                telefono.setText(rs.getString("telefono"));

                r = rs.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoInicial;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField nombreCompleto;
    private javax.swing.JTextField rut;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
