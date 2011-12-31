package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import dei.vlab.communication.model.Circuit;

public class CircuitDaoTest extends BaseDaoTestCase{
	@Autowired
	private CircuitDao cuDao;
	 @Test
	    public void testGetCircuitType() throws Exception {
	        Circuit cUser = cuDao.get(1L);
	        assertNotNull(cUser);
	        
	    }

}
