/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
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

        jButton1 = new javax.swing.JButton();
        selec = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stockActual = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(123, 101, 122));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 659, 70, 30));

        selec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingresar", "Quitar", "Volver a 0" }));
        getContentPane().add(selec, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 107, -1));

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 98, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripción", "Stock Actual", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 764, 380));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 529, 78, 38));

        jLabel1.setText("Código:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 585, -1, -1));

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 605, 120, 28));

        nombre.setFocusable(false);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 605, 203, 28));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 585, -1, -1));

        jLabel4.setText("Stock Actual");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 585, -1, -1));

        stockActual.setFocusable(false);
        getContentPane().add(stockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 605, 61, 28));

        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadKeyPressed(evt);
            }
        });
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 605, 65, 28));

        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 585, -1, -1));

        jButton4.setText("Añadir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 605, 76, 28));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 585, 91, 27));

        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 529, 91, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FondoInventario.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setMaximumSize(new java.awt.Dimension(1024, 700));
        jLabel5.setMinimumSize(new java.awt.Dimension(1024, 700));
        jLabel5.setPreferredSize(new java.awt.Dimension(1024, 700));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardar.setEnabled(true);
        codigo.requestFocus();
        if (("" + selec.getSelectedItem()).equals("Volver a 0")) {
            JOptionPane.showMessageDialog(this, "Para continuar presione guardar, para salir solo cierre", "Información", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BusquedaProducto b = new BusquedaProducto(this, true);
        b.setVisible(true);
        cantidad.requestFocus();
        codigo.setText(b.obtenerCodigo());
        nombre.setText(b.obtenerNombre());
        stockActual.setText(b.obtenerStock());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;

            try {
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos WHERE codigo = ? ");
                stmt.setString(1, (codigo.getText()));
                ResultSet rs;
                rs = stmt.executeQuery();
                boolean r = rs.next();
                if (r == false) {
                    JOptionPane.showMessageDialog(this, "Código no existe", "Información", JOptionPane.INFORMATION_MESSAGE);

                    codigo.requestFocus();
                    codigo.setText("");
                } else {
                    while (r) {

                        nombre.setText(rs.getString("nombre"));
                        stockActual.setText(rs.getString("stock"));
                        r = rs.next();
                    }
                    cantidad.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;

            try {
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos WHERE codigo = ? ");
                stmt.setString(1, (codigo.getText()));
                ResultSet rs;
                rs = stmt.executeQuery();
                boolean r = rs.next();
                if (r == false) {
                    JOptionPane.showMessageDialog(this, "Código no existe", "Información", JOptionPane.INFORMATION_MESSAGE);

                    codigo.requestFocus();
                    codigo.setText("");
                } else {
                    while (r) {

                        nombre.setText(rs.getString("nombre"));
                        stockActual.setText(rs.getString("stock"));
                        r = rs.next();
                    }
                    cantidad.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_codigoKeyPressed

    private void cantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton4.requestFocus();
        }
    }//GEN-LAST:event_cantidadKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    public void anadir(){
        int flag = 0;
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        int borrar = 0;
        double repeticion = 0;
        for (int i = 0; i <= a; i++) {
            if (((String) tb.getValueAt(i, 0)).equals(codigo.getText())) {
                borrar = i;
                repeticion = (double) tb.getValueAt(i, 3);
                flag = 1;
            }
        }
        if (codigo.getText().equals("")) {

        } else if (flag == 1) {

            tb.removeRow(borrar);

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            Object[] fila = new Object[4];

            fila[0] = codigo.getText();
            fila[1] = nombre.getText();
            fila[2] = Double.parseDouble(stockActual.getText());
            fila[3] = Double.parseDouble(cantidad.getText()) + repeticion;
            modelo.addRow(fila);

            tabla.setModel(modelo);
        } else {

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            Object[] fila = new Object[4];

            fila[0] = codigo.getText();
            fila[1] = nombre.getText();
            fila[2] = Double.parseDouble(stockActual.getText());
            fila[3] = Double.parseDouble(cantidad.getText());
            modelo.addRow(fila);

            tabla.setModel(modelo);
        }
        codigo.requestFocus();
        codigo.setText("");
        stockActual.setText("");
        nombre.setText("");
        cantidad.setText("");
    }
    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            anadir();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (("" + selec.getSelectedItem()).equals("Ingresar")) {
            insertar();
            registrarAccion("Insertar");
        } else if (("" + selec.getSelectedItem()).equals("Quitar")) {
            quitar();
            registrarAccion("Quitado");
        } else if (("" + selec.getSelectedItem()).equals("Volver a 0")) {

            String name = JOptionPane.showInputDialog("Para volver a 0, escriba 'SI' en mayúsculas");
            if (name.equals("SI")) {
                MySQL my = new MySQL();
                Connection con = my.getConnection();
                Statement sql;
                try {

                    PreparedStatement stmt = con.prepareStatement("UPDATE productos SET stock = 0;");

                    stmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Stock devuelto a 0!", "Información", JOptionPane.INFORMATION_MESSAGE);

                    registrarVueltaA0();
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    //
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error no se efectuaron cambios", "Información", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_guardarActionPerformed

    public void insertar() {
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {

            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                String cod = (String) tb.getValueAt(i, 0);
                double stockactual = (double) tb.getValueAt(i, 2);
                double cant = (double) tb.getValueAt(i, 3);
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("UPDATE productos SET stock = ? WHERE productos.codigo = ?;");
                stmt.setDouble(1, stockactual + cant);
                stmt.setString(2, cod);

                stmt.executeUpdate();

            }
            JOptionPane.showMessageDialog(this, "Stock modificado", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void quitar() {
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {

            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                String cod = (String) tb.getValueAt(i, 0);
                double stockactual = (double) tb.getValueAt(i, 2);
                double cant = (double) tb.getValueAt(i, 3);
                sql = con.createStatement();
                PreparedStatement stmt = con.prepareStatement("UPDATE productos SET stock = ? WHERE productos.codigo = ?;");
                stmt.setDouble(1, stockactual - cant);
                stmt.setString(2, cod);

                stmt.executeUpdate();

            }
            JOptionPane.showMessageDialog(this, "Stock modificado", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public int calcularMax(){
        int cod = 0;
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {

            sql = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("SELECT MAX(codigo)"
                    + "FROM movimientostock;");

            ResultSet rs;
            rs = stmt.executeQuery();

            boolean r = rs.next();
            while (r) {

                cod = rs.getInt("MAX(codigo)") + 1;

                r = rs.next();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cod;
    }
    
    public void registrarVueltaA0() {
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            java.util.Date date = new Date();
            java.sql.Date fechaActual = new java.sql.Date(date.getTime());
            java.sql.Time horaActual = new java.sql.Time(date.getTime());
           
           

                

                
                


                    sql = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO movimientostock (codigo, usuario,"
                            + "movimiento, producto, cantidad, hora, fecha)"
                            + " VALUES (?,?,?,?,?,?,?);");

                    stmt.setInt(1, calcularMax());

                    stmt.setInt(2, MenuPrincipal.usuario);
                    stmt.setString(3, "Vuelta a 0");
                    stmt.setString(4, "");

                    stmt.setDouble(5, 0);

                    stmt.setTime(6, horaActual);
                    stmt.setDate(7, fechaActual);
                    stmt.executeUpdate();

                

            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarAccion(String accion) {
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;
        try {
            java.util.Date date = new Date();
            java.sql.Date fechaActual = new java.sql.Date(date.getTime());
            java.sql.Time horaActual = new java.sql.Time(date.getTime());
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            int a = tabla.getRowCount() - 1;
            int codigo = calcularMax();
            for (int i = 0; i <= a; i++) {
                String cod = (String) tb.getValueAt(i, 0);
                double cant = (double) tb.getValueAt(i, 3);

                

                
                


                    sql = con.createStatement();
                    PreparedStatement stmt = con.prepareStatement("INSERT INTO movimientostock (codigo, usuario,"
                            + "movimiento, producto, cantidad, hora, fecha)"
                            + " VALUES (?,?,?,?,?,?,?);");

                    stmt.setInt(1, codigo);

                    stmt.setInt(2, MenuPrincipal.usuario);
                    stmt.setString(3, accion);
                    stmt.setString(4, cod);

                    stmt.setDouble(5, cant);

                    stmt.setTime(6, horaActual);
                    stmt.setDate(7, fechaActual);
                    stmt.executeUpdate();

                

            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();

        tb.removeRow(tabla.getSelectedRow());

    }//GEN-LAST:event_jButton5ActionPerformed

    private void verificarCamposSinLetras(KeyEvent evt, String tipo, javax.swing.JTextField campoTexto) {
        char c = evt.getKeyChar();
        if (tipo.equals("numero")) {
            if (Character.isLetter(c)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo numeros");
                campoTexto.setCursor(null);
            } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58
                    && (int) evt.getKeyChar() <= 64 || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                    || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo numeros");
                campoTexto.setCursor(null);
            }
        } else if (tipo.equals("rut")) {
            if (Character.isLetter(c)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo números, punto o guión");
                campoTexto.setCursor(null);
            } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 44 || (int) evt.getKeyChar() >= 45 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58
                    && (int) evt.getKeyChar() <= 64 || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                    || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo números, punto o guión");
                campoTexto.setCursor(null);
            }
        } else if (tipo.equals("letras")) {
            if (Character.isDigit(c)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo letras");
                campoTexto.setCursor(null);
            } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58
                    && (int) evt.getKeyChar() <= 64 || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                    || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo letras");
                campoTexto.setCursor(null);
            }

        } else if (tipo.endsWith("numero coma")) {
            if (Character.isLetter(c)) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo números");
                campoTexto.setCursor(null);
            } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 43 || (int) evt.getKeyChar() >= 45 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58
                    && (int) evt.getKeyChar() <= 64 || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                    || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(this, "Ingrese sólo números");
                campoTexto.setCursor(null);
            }

        }

    }
    
    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
         // TODO add your handling code here:
         verificarCamposSinLetras(evt, "numero", codigo);
    }//GEN-LAST:event_codigoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
         // TODO add your handling code here:
         verificarCamposSinLetras(evt, "letras", nombre);
    }//GEN-LAST:event_nombreKeyTyped

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> selec;
    private javax.swing.JTextField stockActual;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
