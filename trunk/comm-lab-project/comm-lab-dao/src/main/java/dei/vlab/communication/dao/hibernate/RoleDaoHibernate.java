
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.RoleDao;
import dei.vlab.communication.model.Role;
@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements RoleDao {

    /**
	 * 
	 */
    public RoleDaoHibernate() {
        super(Role.class);
    }

    public Role findRoleById(Long id) {
        List roleById = getHibernateTemplate().find("from Role where id=?", id);
        if (roleById.isEmpty()) {
            return null;
        }
        return (Role) roleById.get(0);
    }

    public Role findRoleByName(String name) {
        List roles = getHibernateTemplate().find("from Role where name=?", name);
        if (roles.isEmpty()) {
            return null;
        } else {
            return (Role) roles.get(0);
        }
    }

    public Role saveRole(Role roleName) {
        if (log.isDebugEnabled()) {
            log.debug("Update Role is" + roleName);
        }
        System.out.println("role name " + roleName);
        getHibernateTemplate().saveOrUpdate(roleName);
        return roleName;
    }

    public void removeRloeByName(String name) {
        Object role = findRoleByName(name);
        getHibernateTemplate().delete(role);

    }

	public Role findRoleByType(String type) {
		 List roleById = getHibernateTemplate().find("from Role where type=?", type);
	        if (roleById.isEmpty()) {
	            return null;
	        }
	        return (Role) roleById.get(0);
	}
}
