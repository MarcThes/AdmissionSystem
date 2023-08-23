package model;

/**
 * Represents a student with an ID, first name, and last name.
 * <p>
 * This class serves as the model for the student data in the application. It includes properties for id, first name(nom), 
 * and last name(prenom) with corresponding getter and setter methods. This model class can be used to 
 * represent student data retrieved from a database, user input, or application output.
 * </p>
 * <p>
 * The class provides constructors for creating a new student object with or without initial values.
 * </p>
 * 
 * @author Author
 */

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;

    public int getId() {
        return id;
    }
    /**
     * Default constructor - creates an empty Student object.
     */
    public Etudiant() {
    }
    /**
     * Constructor that accepts initial values for each of the fields.
     *
     * @param id the student's ID
     * @param nom the student's first name
     * @param prenom the student's last name
     */
    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    // Rest of the getters and setters...

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    

    
}
