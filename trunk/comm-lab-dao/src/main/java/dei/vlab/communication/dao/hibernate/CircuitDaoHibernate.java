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

    public List findCircuitById(Long id) {
        List circuit = null;
        circuit = getHibernateTemplate().find("from Circuit where id=?", id);
        if (circuit.isEmpty()) {
            return null;
        }
        return circuit;
    }

    public List findAllCircuit() {
        List circuitList = null;
        circuitList = getHibernateTemplate().find("from Circuit");
        if (circuitList.isEmpty()) {
            return null;
        }
        return circuitList;
    }

    public Circuit findCircuitByName(String name) {
        Circuit circuit = null;
        circuit = getHibernateTemplate().load(Circuit.class, name);
        if (circuit == null) {
            return null;
        }
        return circuit;
    }

    public void deletCircuitById(Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Delete circuit id " + id);
        }
        Object deletObject = getHibernateTemplate().load(Circuit.class, id);
        if (deletObject != null) {
            getHibernateTemplate().delete(deletObject);
        }

    }

    public Circuit saveCircuit(Circuit circuit) {
        if (log.isDebugEnabled()) {
            log.debug("save and update " + circuit);
        }
        getHibernateTemplate().saveOrUpdate(circuit);
        return circuit;
    }

}
