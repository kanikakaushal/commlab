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
public class CircuitPrivilegesDaoHibernate extends GenericDaoHibernate<CircuitPrivileges, Long> implements CircuitPrivilegesDao {

	/**
	 * 
	 */
	public CircuitPrivilegesDaoHibernate() {
		super(CircuitPrivileges.class);
	}

	public CircuitPrivileges getPrivilegeByName(String circuitName) {
		CircuitPrivileges circuitPrivivalge=null;
		try {
			System.out.println("hiii i am in the Circuit Privilege Hibernate class");
			circuitPrivivalge = getHibernateTemplate().load(CircuitPrivileges.class, circuitName);
			if(circuitPrivivalge==null){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuitPrivivalge;
	}

	public CircuitPrivileges getprivilegesById(Long privId) {
		CircuitPrivileges circuitPrivById=null;
		try {
			circuitPrivById = getHibernateTemplate().load(CircuitPrivileges.class, privId);
			if(circuitPrivById==null){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuitPrivById;
	}


	public CircuitPrivileges savePrivilage(CircuitPrivileges cirPrivilege) {
		 if (log.isDebugEnabled()) {
	            log.debug("Save and update  id: " + cirPrivilege);
	        }
		
		try {
			getHibernateTemplate().saveOrUpdate(cirPrivilege);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cirPrivilege;
	}

	public void deletprivilege(Long PrivId) {
		 if (log.isDebugEnabled()) {
	            log.debug("delete privilege  id: " + PrivId);
	        }
		 try {
			Object delObject = getHibernateTemplate().load(CircuitPrivileges.class, PrivId);
			if(delObject!=null){
				getHibernateTemplate().delete(delObject);
				getHibernateTemplate().flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
}
