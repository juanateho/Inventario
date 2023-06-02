package vista;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conectar;


/**
 *
 * @author juana
 */
public class ConsultaEdicionProductos extends javax.swing.JFrame {

    Conectar conexion = new Conectar();
    Connection con = conexion.getConnection();

    public ConsultaEdicionProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarDatos();
    }

    private void MostrarDatos() {

        String sql = "SELECT * FROM inventario";
        Statement st;
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio c/u");
        model.addColumn("Proveedor");
        model.addColumn("Tipo");

        tlbProductos.setModel(model);

        String[] dato = new String[6];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(4);
                dato[3] = result.getString(3);
                dato[4] = result.getString(7);
                dato[5] = result.getString(5);
                model.addRow(dato);
            }

            tlbProductos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex + "Error en la consulta.");
        }
    }
    
    public void ModificarDatos() {
        
        int fila = tlbProductos.getSelectedRow();
        
        String valor =tlbProductos.getValueAt(fila, 0).toString();
        
        String nombre = tlbProductos.getValueAt(fila, 1).toString();
        String descripcion = tlbProductos.getValueAt(fila, 2).toString();
        String precio = tlbProductos.getValueAt(fila, 3).toString();
        String proveedor = tlbProductos.getValueAt(fila, 4).toString();
        String tipo = tlbProductos.getValueAt(fila, 5).toString();
        
         String sql = " UPDATE inventario SET nombre='"+nombre+"',descripcion='"+descripcion+"',precio='"+precio+"',proveedor='"+proveedor+"',tipo='"+tipo+"' WHERE id='"+valor+"' ";
        
        try {
            PreparedStatement modify = con.prepareStatement(sql);
            modify.executeUpdate();
            MostrarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logró actualizar los datos.");
        }
        
        MostrarDatos();
    }
    
    public void EliminarDatos() {
        int fila = tlbProductos.getSelectedRow();
        
        String valor =tlbProductos.getValueAt(fila, 0).toString();
        
        String sql = "DELETE FROM inventario WHERE id = '"+valor+"'";
        
        try {
            PreparedStatement delete = con.prepareStatement(sql);
            delete.executeUpdate();
            MostrarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logró eliminar el dato.");
        }
        
        MostrarDatos();
    }
    
    public void BuscarRegistro() {
        
        String valor = txtBuscarProductos.getText();
        
        String sql = "SELECT * FROM inventario WHERE id like '"+"%"+valor+"%' OR nombre like '"+"%"+valor+"%'";
        Statement st;
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio c/u");
        model.addColumn("Proveedor");
        model.addColumn("Tipo");

        tlbProductos.setModel(model);

        String[] dato = new String[6];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(4);
                dato[3] = result.getString(3);
                dato[4] = result.getString(7);
                dato[5] = result.getString(5);
                model.addRow(dato);
            }

            tlbProductos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex + "Error en la consulta.");
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarProductos = new javax.swing.JTextField();
        btnModificarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbProductos = new javax.swing.JTable();
        btnBuscarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de productos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Formulario para la gestión de productos");

        btnModificarProducto.setText("Modificar");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        tlbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tlbProductos);

        btnBuscarRegistro.setText("Buscar");
        btnBuscarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarRegistro)
                                .addGap(43, 43, 43)
                                .addComponent(btnModificarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificarProducto)
                        .addComponent(btnEliminarProducto))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarRegistro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        ModificarDatos();
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        EliminarDatos();
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnBuscarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistroActionPerformed
        BuscarRegistro();
    }//GEN-LAST:event_btnBuscarRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEdicionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarRegistro;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tlbProductos;
    private javax.swing.JTextField txtBuscarProductos;
    // End of variables declaration//GEN-END:variables
}
