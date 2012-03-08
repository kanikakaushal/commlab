/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.CircuitPrivilegesDao;
import dei.vlab.communication.model.CircuitPrivileges;

/**
 * @author server
 * 
 */
@Repository
public class CircuitPrivilegesDaoHibernate extends GenericDaoHibernate<CircuitPrivileges, Long> implements
        CircuitPrivilegesDao {

    /**
	 * 
	 */
    public CircuitPrivilegesDaoHibernate() {
        super(CircuitPrivileges.class);
    }

    public CircuitPrivileges savePrivilage(CircuitPrivileges cirPrivilege) {
        if (log.isDebugEnabled()) {
            log.debug("Save and update  id: " + cirPrivilege);
        }
        getHibernateTemplate().saveOrUpdate(cirPrivilege);

        return cirPrivilege;
    }

    public CircuitPrivileges findPrivilegeByName(String name) {
        List circuitPrivivalge = null;
        circuitPrivivalge = getHibernateTemplate().find("from CircuitPrivileges where name=?", name);
        if (circuitPrivivalge.isEmpty()) {
            return null;
        }
        return (CircuitPrivileges) circuitPrivivalge.get(0);
    }

    public CircuitPrivileges findprivilegesById(Long id) {
        List circuitPrivivalgeById = null;
        circuitPrivivalgeById = getHibernateTemplate().find("from CircuitPrivileges where id=?", id);
        if (circuitPrivivalgeById.isEmpty()) {
            return null;
        }
        return (CircuitPrivileges) circuitPrivivalgeById.get(0);
    }

    public void deletPrivilegeById(Long id) {
        if (log.isDebugEnabled()) {
            log.debug("delete privilege  id: " + id);
        }
        Object delObject = getHibernateTemplate().load(CircuitPrivileges.class, id);

        if (delObject != null) {
            getHibernateTemplate().delete(delObject);
            getHibernateTemplate().flush();
        }
    }

}
