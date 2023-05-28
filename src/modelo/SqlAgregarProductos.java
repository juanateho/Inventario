package modelo;

import com.mysql.cj.xdevapi.Result;
import vista.ConsultaEdicionProductos;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juana
 */
public class SqlAgregarProductos extends Conectar {

    Conectar conexion = new Conectar();
    PreparedStatement ps = null;
    Connection con = getConnection();

    public boolean registrar(Productos pr) {

        String sql = "INSERT INTO inventario (nombre, descripcion, precio, proveedor, tipo, unidades) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getDescripcion());
            ps.setString(3, pr.getPrecio());
            ps.setString(4, pr.getProveedor());
            ps.setString(5, pr.getTipo());
            ps.setString(6, pr.getUnidades());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlAgregarProductos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public void MostrarProductos() {
        String sql = "SELECT id, nombre, descripcion, precio, proveedor, tipo FROM inventario";

        Statement st;

        String[] dato = new String[5];
        
        DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Nombre");
                model.addColumn("Descripción");
                model.addColumn("Precio");
                model.addColumn("Proveedor");
                model.addColumn("Tipo");

                ConsultaEdicionProductos tabla = new ConsultaEdicionProductos();

                tabla.tlbProductos.setModel(model);

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
        } catch (Exception e) {
        }

    }
}
