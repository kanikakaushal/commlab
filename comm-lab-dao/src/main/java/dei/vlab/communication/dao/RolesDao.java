/**
 * 
 */
package dei.vlab.communication.dao;

import dei.vlab.communication.model.Role;

/**
 * @author server
 *
 */
public interface RolesDao extends  GenericDao<Role, Long>  {
	
	/*
	 * get role information based on rolename
	 */
	
	Role getRoleByName(String roleNmae);
	/*
	 * Remove a role from the database by name
	 */
	 void removeRloe(String roleNmae);
	 /*
	  * Save and Update role from the database.
	  */
	 Role saveRole(Role roleName);
	

}
