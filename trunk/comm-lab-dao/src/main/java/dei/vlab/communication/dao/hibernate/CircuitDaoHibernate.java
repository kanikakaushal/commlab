/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.CircuitDao;
import dei.vlab.communication.model.Circuit;

/**
 * @author server
 *
 */
@Repository
public class CircuitDaoHibernate extends GenericDaoHibernate<Circuit, Long> implements CircuitDao {

	/**
	 * 
	 */
	public CircuitDaoHibernate() {
		super(Circuit.class);
	}

	public Circuit getCircuitById(Long circuitId) {
		Circuit circuit=null;
		try {
			circuit=getHibernateTemplate().load(Circuit.class, circuitId);
			if(circuit==null){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuit;
	}

	public List getCircuit() {
		List circuitList=null;
		try {
			circuitList= getHibernateTemplate().find("from Circuit");
			if(circuitList.isEmpty()){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuitList;
	}

	public Circuit getCircuitByName(String circuitName) {
		Circuit circuitByName=null;
		try {
			System.out.println(">>>>>>>>>>>>>hiii i an in Circuit dao hibernate calss>>>>>>>>");
			circuitByName= getHibernateTemplate().load(Circuit.class, circuitName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuitByName;
	}

	public Circuit saveCircuit(Circuit circuit) {
		if(log.isDebugEnabled()){
			log.debug("save and update "+circuit);		
		}
		try {
			getHibernateTemplate().saveOrUpdate(circuit);
			getHibernateTemplate().flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return circuit;
	}

	public void deletCircuit(Long curcuitId) {
		if(log.isDebugEnabled()){
			log.debug("Delete circuit id "+curcuitId);		
		}
		try {
				Object deletObject= getHibernateTemplate().load(Circuit.class, curcuitId);
				if(deletObject!=null){
					getHibernateTemplate().delete(deletObject);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

}
