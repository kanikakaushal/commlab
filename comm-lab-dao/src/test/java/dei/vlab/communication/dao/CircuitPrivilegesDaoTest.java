/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.CircuitPrivileges;

/**
 * @author server
 *
 */
public class CircuitPrivilegesDaoTest extends BaseDaoTestCase {

	@Autowired
	private CircuitPrivilegesDao cirPrivDao;
	
	@Test
	public void getTestCircuitByName() throws Exception{
		CircuitPrivileges cirPrev= cirPrivDao.getPrivilegeByName("gotuam");
		assertNull(cirPrev);
	}
}
