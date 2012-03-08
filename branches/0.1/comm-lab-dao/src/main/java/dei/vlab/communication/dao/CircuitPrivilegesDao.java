package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.CircuitPrivileges;

public interface CircuitPrivilegesDao extends GenericDao<CircuitPrivileges, Long> {
    /*
     * Find Circuit Privileges by name from circuit_privileges table.
     */

    CircuitPrivileges findPrivilegeByName(String name);

    /*
     * Find Circuit Privileges by Id from circuit_privileges table.
     */
    CircuitPrivileges findprivilegesById(Long id);

    /*
     * Save and update privilege
     */
    CircuitPrivileges savePrivilage(CircuitPrivileges circuitPrivilege);

    /*
     * Delete privilege
     */
    void deletPrivilegeById(Long id);
}