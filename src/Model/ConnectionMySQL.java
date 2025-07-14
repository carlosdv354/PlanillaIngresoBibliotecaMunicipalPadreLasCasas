package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    private static final String data_base = "ingresosdb";
    private static final String user = "root";
    private static final String password = "stuxnet";
    private static final String URL = "jdbc:mysql://localhost:3306/" + data_base;

    public Connection getConnection() {
        Connection conn = null;
        try {
            // Cargar el driver (opcional desde Java 6 en adelante)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }

        return conn;
    }
}
