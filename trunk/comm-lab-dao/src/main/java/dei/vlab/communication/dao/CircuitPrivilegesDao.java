package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.CircuitPrivileges;

public interface CircuitPrivilegesDao extends GenericDao<CircuitPrivileges,Long> {
	/*
	 * Get Circuit Privileges from circuit_privileges.
	 */
	CircuitPrivileges getPrivilegeByName(String circuitNmae);
	/*
	 * Get Circuit Privileges by Id from circuit_privileges.
	 */
	CircuitPrivileges getprivilegesById(Long privId);
	/*
	 * save and update privilege
	 */
	CircuitPrivileges savePrivilage(CircuitPrivileges cirPrivilege);
	/*
	 * Delete privilege 
	 */
	void deletprivilege(Long PrivId);
}