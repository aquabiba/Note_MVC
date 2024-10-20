package ensa.jee.notes_mvc.mod.sco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {

    private static final String URL = "jdbc:postgresql://localhost:5432/scolarite";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";


    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Charger le driver JDBC pour PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données PostgreSQL !");
        } catch (ClassNotFoundException e) {
            System.err.println("Le driver PostgreSQL n'a pas été trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
        return connection;
    }

}
