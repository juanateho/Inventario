package modelo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author juana
 */
public class Conectar {

    private String userDatabase = "root";
    private String passwordDatabase = "";
    private String nameDatabase = "ProductosInventario";

    private Connection connection = null;

    public Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3307/" + nameDatabase,
                    userDatabase, passwordDatabase);
            if (connection != null) {
                System.out.println("Conexion establecida.");
            }
            System.out.println("");

        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
