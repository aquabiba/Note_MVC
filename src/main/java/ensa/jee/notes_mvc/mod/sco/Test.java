package ensa.jee.notes_mvc.mod.sco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Note N1 = new Note(1,"10", "Gestion Projet", 18);

        String query = "INSERT INTO notes VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement st = null;

        try {
            // Obtenir la connexion à la base de données
            conn = DatabaseConn.getConnection();

            // Vérifier si la connexion est établie
            if (conn != null) {
                // Préparer la requête d'insertion
                st = conn.prepareStatement(query);
                st.setInt(1, N1.getId_note());
                st.setString(2, N1.getNum_ins());
                st.setString(3, N1.getMatiere());
                st.setFloat(4, N1.getNote());

                // Exécuter la requête d'insertion
                int rowsInserted = st.executeUpdate();

                // Vérifier si l'insertion a réussi
                if (rowsInserted > 0) {
                    System.out.println("Note ajoutée avec succès !");
                }
            } else {
                System.err.println("Échec de la connexion à la base de données.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de la note : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fermer les ressources (PreparedStatement et Connection)
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

