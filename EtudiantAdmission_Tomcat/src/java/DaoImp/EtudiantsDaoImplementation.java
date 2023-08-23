package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.EtudiantDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Etudiant;

/**
 * This class implements the EtudiantDao interface and provides concrete implementations for the CRUD operations on the Etudiant model.
 * 
 * <p>
 * The class uses a Connection object to interact with the database. The Connection object is obtained from the ConnectionFactory class.
 * </p>
 * 
 * <p>
 * The class provides the following methods:
 * <ul>
 * <li>create(Etudiant etudiant): Inserts a new Etudiant into the database.</li>
 * <li>findById(int id): Retrieves an Etudiant from the database based on the provided ID.</li>
 * <li>findAll(): Retrieves all Etudiants from the database.</li>
 * <li>update(Etudiant etudiant): Updates the information of an existing Etudiant in the database.</li>
 * <li>delete(int id): Deletes an Etudiant from the database based on the provided ID.</li>
 * </ul>
 * </p>
 * 
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */

public class EtudiantsDaoImplementation implements EtudiantDao {

    Connection connection = ConnectionFactory.getConnection();

    // Constructor 
    public EtudiantsDaoImplementation() {

    }

    // Create a new Etudiant
    @Override
    public void create(Etudiant etudiant) {

        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO Etudiants(etudiant_id, nom, prenom) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);

            preparedStatement.setInt(1, etudiant.getId());
            preparedStatement.setString(2, etudiant.getNom());
            preparedStatement.setString(3, etudiant.getPrenom());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find by id
    @Override
    public Etudiant findById(int id) {

        Etudiant etudiant = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM Etudiants WHERE etudiant_id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            etudiant = new Etudiant();
            etudiant.setId(resultSet.getInt("etudiant_id"));
            etudiant.setNom(resultSet.getString("nom"));
            etudiant.setPrenom(resultSet.getString("prenom"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return etudiant;
    }

    // find All etudiants
    @Override
    public List<Etudiant> findAll() {

        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant etudiant = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM Etudiants ORDER BY etudiant_id";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("etudiant_id"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiants.add(etudiant);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etudiants;
    }

    // Update etudiant's info
    @Override
    public void update(Etudiant etudiant) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE Etudiants SET nom = ?, prenom = ? WHERE etudiant_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setInt(3, etudiant.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete etudiant
    @Override
    public void delete(int id) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM Etudiants WHERE etudiant_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
