package interfaceDao;

import java.util.List;
import model.Etudiant;

/**
 * This interface defines methods for CRUD operations on 'Etudiant' entities in the underlying data store.
 *
 * <p>
 * The methods defined in this interface include:
 * <ul>
 * <li>create: Adds a new Etudiant to the data store.</li>
 * <li>update: Updates an existing Etudiant in the data store.</li>
 * <li>delete: Removes an Etudiant from the data store by its id.</li>
 * <li>findAll: Lists all Etudiants from the data store.</li>
 * <li>findById: Retrieves a specific Etudiant from the data store by its id.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The EtudiantDao interface provides a standard set of operations required for managing Etudiant entities, which can be implemented in any type of data store - such as a relational database or an in-memory database.
 * </p>
 * 
 * @author MarcT
 */
public interface EtudiantDao {

    void create(Etudiant etudiant);

    void update(Etudiant etudiant);

    void delete(int id);

    List<Etudiant> findAll();

    Etudiant findById(int id);
}
