package dei.vlab.communication.dao.hibernate;

import org.springframework.stereotype.Repository;

import antlr.collections.List;

import dei.vlab.communication.dao.CircuitUserDao;
import dei.vlab.communication.model.CircuitUser;


@Repository("CircuitUserDao")

public class CircuitUserDaoHibernate extends GenericDaoHibernate<CircuitUser, Long> implements CircuitUserDao   {
	
	public CircuitUserDaoHibernate(){
		super(CircuitUser.class);
	}

	public List getCircuitType(Long circuitId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
