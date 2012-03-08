package dei.vlab.communication.dao;

import dei.vlab.communication.model.Role;

public interface RoleDao extends GenericDao<Role, Long> {

	/*
	 * Find role information based on name
	 */
	Role findRoleByName(String name);

	/*
	 * find role by id in the role table
	 */
	Role findRoleById(Long id);
	Role findRoleByType(String type);


	/*
	 * Remove a role from the database by name
	 */
	void removeRloeByName(String name);

	/*
	 * Save and Update role from the database.
	 */
	Role saveRole(Role role);

}
