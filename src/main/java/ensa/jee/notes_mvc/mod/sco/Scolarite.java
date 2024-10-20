package ensa.jee.notes_mvc.mod.sco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Scolarite {
    public Vector<Note> getNotes(String num_ins){
        Vector<Note> notes = new Vector<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConn.getConnection();

            String query = "SELECT note,matiere FROM notes WHERE num_ins = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, num_ins);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
//                String num = resultSet.getString("num_ins");
                String matiere = resultSet.getString("matiere");
                float N = resultSet.getFloat("note");
                Note note = new Note(matiere, N);
                notes.add(note);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des notes : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return notes;
    };
}
