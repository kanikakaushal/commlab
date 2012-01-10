/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.RolesDao;
import dei.vlab.communication.model.Role;

/**
 * @author server
 *
 */
@Repository
public class RolesDaoHibernate  extends GenericDaoHibernate<Role, Long> implements RolesDao{

	/**
	 * 
	 */
	public RolesDaoHibernate() {
		super(Role.class);
	}

	public Role getRoleByName(String roleNmae) {
		System.out.println("hii this is starting ");
		List roles= getHibernateTemplate().find("from Role where name=?",roleNmae);
		if(roles.isEmpty()){
			return null;
		}else {
			return (Role) roles.get(0);
		}	
	}

	public void removeRloe(String roleNmae) {
		Object role = getRoleByName(roleNmae);
		getHibernateTemplate().delete(role);
		
	}

	public Role saveRole(Role roleName) {
		if(log.isDebugEnabled()){
			log.debug("Update Role is"+roleName);		
		}
		getHibernateTemplate().saveOrUpdate(roleName);
		getHibernateTemplate().flush();
		return roleName;
	}

}
