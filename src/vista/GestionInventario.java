package vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conectar;

/**
 *
 * @author juana
 */
public class GestionInventario extends javax.swing.JFrame {
    
    Conectar conexion = new Conectar();
    Connection con = conexion.getConnection();

    public GestionInventario() {
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
        model.addColumn("Proveedor");
        model.addColumn("Unidades");

        tlbInventario.setModel(model);

        String[] dato = new String[5];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(4);
                dato[3] = result.getString(7);
                dato[4] = result.getString(6);
                model.addRow(dato);
            }

            tlbInventario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex + "Error en la consulta.");
        }
    }
    
    public void ModificarDatos() {
        
        int fila = tlbInventario.getSelectedRow();
        
        String valor =tlbInventario.getValueAt(fila, 0).toString();
        String unidades = tlbInventario.getValueAt(fila, 4).toString();
        
         String sql = " UPDATE inventario SET unidades='"+unidades+"' WHERE id='"+valor+"' ";
        
        try {
            PreparedStatement modify = con.prepareStatement(sql);
            modify.executeUpdate();
            MostrarDatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logró actualizar los datos.");
        }
        
        MostrarDatos();
    }
    
    public void ExportarRegistros() {
        String sql = "SELECT * INTO OUTFILE 'C:/Users/juana/OneDrive/Escritorio/inventario.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' FROM inventario";
        
        try {
            PreparedStatement export = con.prepareStatement(sql);
            export.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "No se logró exportar la información.");
        }
    }
    
    public void BuscarRegistro() {
        String valor = txtBuscarInventario.getText();
        
        String sql = "SELECT * FROM inventario WHERE id like '"+"%"+valor+"%' OR nombre like '"+"%"+valor+"%'";
        Statement st;
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Proveedor");
        model.addColumn("Unidades");

        tlbInventario.setModel(model);

        String[] dato = new String[5];

        try {
            st = con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                dato[0] = result.getString(1);
                dato[1] = result.getString(2);
                dato[2] = result.getString(4);
                dato[3] = result.getString(7);
                dato[4] = result.getString(6);
                model.addRow(dato);
            }

            tlbInventario.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaEdicionProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex + "Error en la consulta.");
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarInventario = new javax.swing.JTextField();
        btnModificarInventario = new javax.swing.JButton();
        btnExportarInventario = new javax.swing.JButton();
        btnCerrarInventario = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbInventario = new javax.swing.JTable();
        btnBuscarInventario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de inventario");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Formulario para la gestión del Inventario");

        btnModificarInventario.setText("Modificar");
        btnModificarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInventarioActionPerformed(evt);
            }
        });

        btnExportarInventario.setText("Exportar");
        btnExportarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarInventarioActionPerformed(evt);
            }
        });

        btnCerrarInventario.setText("Cerrar");
        btnCerrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarInventarioActionPerformed(evt);
            }
        });

        tlbInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tlbInventario);

        btnBuscarInventario.setText("Buscar");
        btnBuscarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnExportarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCerrarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarInventario))
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportarInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrarInventario)
                        .addGap(79, 79, 79))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInventarioActionPerformed
        ModificarDatos();
    }//GEN-LAST:event_btnModificarInventarioActionPerformed

    private void btnExportarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarInventarioActionPerformed
        ExportarRegistros();
    }//GEN-LAST:event_btnExportarInventarioActionPerformed

    private void btnCerrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarInventarioActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarInventarioActionPerformed

    private void btnBuscarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarInventarioActionPerformed
        BuscarRegistro();
    }//GEN-LAST:event_btnBuscarInventarioActionPerformed

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
            java.util.logging.Logger.getLogger(GestionInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarInventario;
    private javax.swing.JButton btnCerrarInventario;
    private javax.swing.JButton btnExportarInventario;
    private javax.swing.JButton btnModificarInventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tlbInventario;
    private javax.swing.JTextField txtBuscarInventario;
    // End of variables declaration//GEN-END:variables
}
