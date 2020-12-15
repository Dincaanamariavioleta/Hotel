package Model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection = null;
    private final String url = "jdbc:postgresql://localhost:5432/Hotel Management"; //adresa unui site web
    private final String user = "postgres";
    private final String password = "123456789";

    public Connection dbConnection()
    {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conectat");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare de conectare");
        }
        return connection;
    }
}
