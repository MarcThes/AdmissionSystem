package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides methods to establish and close a connection to a database.
 * 
 * <p>
 * The class uses the DriverManager class from the java.sql package to establish a connection to the database. The URL, username, and password for the database are defined as constants.
 * </p>
 * 
 * <p>
 * The class provides the following methods:
 * <ul>
 * <li>getConnection(): Establishes and returns a Connection object. If a connection cannot be established, a RuntimeException is thrown.</li>
 * <li>closeConnection(): Closes the Connection object if it is not null.</li>
 * </ul>
 * </p>
 * 
 * @author MarcT
 * @version 1.0
 * @since 2023-06-01
 */

public class ConnectionFactory {

    private static Connection connection = null;

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "hr";
    public static final String PASS = "oracle";

        // Method to establish and return a database connection
    public static Connection getConnection() {
        
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Establish and return a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    // Method to close the database connection
    public void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }
}
