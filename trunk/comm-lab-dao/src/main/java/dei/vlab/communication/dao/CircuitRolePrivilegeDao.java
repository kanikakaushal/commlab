/**
 * 
 */
package dei.vlab.communication.dao;

import dei.vlab.communication.model.CircuitRolePrivilege;

/**
 * @author server
 *
 */
public interface CircuitRolePrivilegeDao extends GenericDao<CircuitRolePrivilege, Long>{
	
	/*
	 * Find Circuit Role Privilege 
	 */
	CircuitRolePrivilege findCircuitRolePrivilegeById(Long id);
	/*
	 * Save Circuit Role Privilege 
	 */
	CircuitRolePrivilege saveCircuitRoleprivlilege(CircuitRolePrivilege circuitRolePrivilege);
	/*
	 * Delete Circuit Role Privilege by id
	 */	
	void deleteCorcuitRolePrivielgeById(Long id);
	
}
