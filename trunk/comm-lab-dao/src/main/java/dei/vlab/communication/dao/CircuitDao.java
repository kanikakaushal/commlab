/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.Circuit;

/**
 * @author server
 * 
 */

public interface CircuitDao extends GenericDao<Circuit, Long> {

    /*
     * 
     * Find Circuit by id from circuit table into the database.
     */

    Circuit findCircuitById(Long id);

    /*
     * Find All list of the circuit from circuit table into the database
     */
    List findAllCircuit();

    /*
     * Find Circuit by Circuit name from circuit table into database
     */
    List findCircuitByName(String name);

    /*
     * Save circuit into database in circuit table.
     */
    Circuit saveCircuit(Circuit circuit);

    /*
     * Delete circuit circuit table from the database
     */
    void deletCircuitById(Long id);

}
