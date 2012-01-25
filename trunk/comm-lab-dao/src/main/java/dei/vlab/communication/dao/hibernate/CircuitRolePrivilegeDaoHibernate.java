/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.CircuitRolePrivilegeDao;
import dei.vlab.communication.model.CircuitRolePrivilege;

/**
 * @author server
 *
 */
@Repository
public class CircuitRolePrivilegeDaoHibernate extends GenericDaoHibernate<CircuitRolePrivilege, Long> implements CircuitRolePrivilegeDao {

	/**
	 * 
	 */
	public CircuitRolePrivilegeDaoHibernate() {
		super(CircuitRolePrivilege.class);
	}

	

	public CircuitRolePrivilege findCircuitRolePrivilegeById(Long id) {
		CircuitRolePrivilege circuitRoleById=null; 
		circuitRoleById= getHibernateTemplate().load(CircuitRolePrivilege.class, id);
		if(circuitRoleById== null){
			return null;
		}
		return circuitRoleById;
	}

	public CircuitRolePrivilege saveCircuitRoleprivlilege(
			CircuitRolePrivilege circuitRolePrivilege) {
		getHibernateTemplate().saveOrUpdate(circuitRolePrivilege); 
		return circuitRolePrivilege;
	}

	public void deleteCorcuitRolePrivielgeById(Long id) {
		Object deletCirRolPrev=null;
		deletCirRolPrev=getHibernateTemplate().load(CircuitRolePrivilege.class, id);
		if(deletCirRolPrev!=null){
			getHibernateTemplate().delete(deletCirRolPrev);
		}
		
	}

	
	

	
}
