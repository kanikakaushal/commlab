package dei.vlab.communication.dao;

import antlr.collections.List;
import dei.vlab.communication.model.Circuit;


public interface CircuitDao extends GenericDao<Circuit, Long> {
	
	List getCircuitType(Long circuitId);

}
