package dei.vlab.communication.dao;

import antlr.collections.List;
import dei.vlab.communication.model.CircuitUser;


public interface CircuitUserDao extends GenericDao<CircuitUser, Long> {
	
	List getCircuitType(Long circuitId);

}
