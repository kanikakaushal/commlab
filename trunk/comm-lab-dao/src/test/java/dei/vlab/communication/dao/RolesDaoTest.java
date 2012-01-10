/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Role;

/**
 * @author server
 *
 */
public class RolesDaoTest extends BaseDaoTestCase{
	@Autowired
	private RolesDao roleDao;
	
	@Test
	public void testGetRoleInvalid() throws Exception{
		Role role = roleDao.getRoleByName("goutam");
		 assertNull(role);
	}

}
