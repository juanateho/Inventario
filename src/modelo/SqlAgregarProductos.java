package modelo;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
}
