package dei.vlab.communication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dei.vlab.communication.dao.CircuitDao;
import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.service.CircuitManager;

@Service("circuitManager")
public class CircuitManagerImpl  extends GenericManagerImpl<Circuit, Long> implements CircuitManager {

	public CircuitDao circuitDao;
	
	@Autowired
	public void setCircuitDao(CircuitDao circuitDao) {
		this.circuitDao = circuitDao;
	}

	public Circuit getCircuitByName(String name) {
		return circuitDao.findCircuitByName(name);
	}

	public void saveUpdate(Circuit circuit) {
		circuitDao.saveCircuit(circuit);
	}

	public List<Circuit> getALL() {
		// TODO Auto-generated method stub
		return circuitDao.findAllCircuit();
	}

	public Circuit getCircutById(Long id) {
		// TODO Auto-generated method stub
		return circuitDao.findCircuitById(id);
	}
	
}
