package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import dei.vlab.communication.model.CircuitUser;

public class CircuitUserDaoTest extends BaseDaoTestCase{
	@Autowired
	private CircuitUserDao cuDao;
	 @Test
	    public void testGetCircuitType() throws Exception {
	        CircuitUser cUser = cuDao.get(1L);
	        assertNotNull(cUser);
	        
	    }

}
