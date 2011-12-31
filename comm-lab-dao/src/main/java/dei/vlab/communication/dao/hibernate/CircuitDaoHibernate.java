package dei.vlab.communication.dao.hibernate;

import org.springframework.stereotype.Repository;

import antlr.collections.List;

import dei.vlab.communication.dao.CircuitDao;
import dei.vlab.communication.model.Circuit;


@Repository("CircuitUserDao")

public class CircuitDaoHibernate extends GenericDaoHibernate<Circuit, Long> implements CircuitDao   {
	
	public CircuitDaoHibernate(){
		super(Circuit.class);
	}

	public List getCircuitType(Long circuitId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
