/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class BusquedaProducto extends javax.swing.JDialog {

    /**
     * Creates new form Busqueda
     */
    private String codigo;
    private String nombre;
    private String precio;
    private String stock;
    private static final String solve = "Solve";

    public BusquedaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);
        tabla.getActionMap().put(solve, new EnterAction());
    }

    private class EnterAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();

            codigo = "" + dtm.getValueAt(tabla.getSelectedRow(), 0);
            nombre = "" + dtm.getValueAt(tabla.getSelectedRow(), 1);
            precio = "" + dtm.getValueAt(tabla.getSelectedRow(), 2);
            stock = "" + dtm.getValueAt(tabla.getSelectedRow(), 3);
            dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscartxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(709, 564));
        setMinimumSize(new java.awt.Dimension(709, 564));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscartxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscartxtKeyTyped(evt);
            }
        });
        getContentPane().add(buscartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 352, 28));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 80, 28));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 627, 340));

        jButton2.setBackground(new java.awt.Color(123, 101, 122));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 500, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(725, 603));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        codigo = "" + dtm.getValueAt(tabla.getSelectedRow(), 0);
        nombre = "" + dtm.getValueAt(tabla.getSelectedRow(), 1);
        precio = "" + dtm.getValueAt(tabla.getSelectedRow(), 2);
        stock = "" + dtm.getValueAt(tabla.getSelectedRow(), 3);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminar();
        MySQL my = new MySQL();
        Connection con = my.getConnection();
        Statement sql;

        try {
            sql = con.createStatement();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos WHERE nombre LIKE ?");
            stmt.setString(1, "%" + buscartxt.getText() + "%");
            ResultSet rs;
            rs = stmt.executeQuery();
            System.out.println("CONSULTA EJECUTADA");
            eliminar();
            boolean r = rs.next();
            while (r) {

                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

                Object[] fila = new Object[4];

                fila[0] = rs.getString("codigo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("total");
                fila[3] = rs.getInt("stock");
                modelo.addRow(fila);

                tabla.setModel(modelo);

                r = rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscartxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartxtKeyTyped


    }//GEN-LAST:event_buscartxtKeyTyped

    private void buscartxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartxtKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tabla.requestFocus();
            tabla.changeSelection(0, 0, false, false);
        } else {
            eliminar();
            MySQL my = new MySQL();
            Connection con = my.getConnection();
            Statement sql;

            try {
                sql = con.createStatement();

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos WHERE nombre LIKE ?");
                stmt.setString(1, "%" + buscartxt.getText() + "%");
                ResultSet rs;
                rs = stmt.executeQuery();
                eliminar();
                boolean r = rs.next();
                while (r) {

                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

                    Object[] fila = new Object[4];

                    fila[0] = rs.getString("codigo");
                    fila[1] = rs.getString("nombre");
                    fila[2] = rs.getInt("total");
                    fila[3] = rs.getInt("stock");
                    modelo.addRow(fila);

                    tabla.setModel(modelo);

                    r = rs.next();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buscartxtKeyReleased

    public void eliminar() {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public String obtenerCodigo() {
        return codigo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerPrecio() {
        return precio;
    }

    public String obtenerStock() {
        return stock;
    }

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
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BusquedaProducto dialog = new BusquedaProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscartxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
