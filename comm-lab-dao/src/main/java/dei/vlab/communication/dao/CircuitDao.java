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
	 *  Get Circuit by id from circuit table into the database.
	 */
	
	Circuit getCircuitById(Long circuitId);
	/*
	 * Get all list of the circuit from circuit table into the database
	 */
	List getCircuit();
	/*
	 * Get Circuit by Circuit name from circuit table into database
	 */
	Circuit getCircuitByName(String circuitName);
	/*
	 * save circuit into database in circuit table.
	 */
	Circuit saveCircuit(Circuit circuit);
	/*
	 * Delete circuit circuit table from  the database 
	 */
	void deletCircuit(Long curcuitId);
	

}
