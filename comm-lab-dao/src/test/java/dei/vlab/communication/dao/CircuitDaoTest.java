/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Circuit;

/**
 * @author server
 *
 */
public class CircuitDaoTest extends BaseDaoTestCase {
	@Autowired
	private CircuitDao cDao;
	
	@Test
	public void getCircuitByName() throws Exception{
		Circuit circuit = cDao.getCircuitByName("gotuanm");
		 assertNull(circuit);
			}
	
}
