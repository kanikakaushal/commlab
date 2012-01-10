/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNull;

import javax.persistence.Table;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.UserDetail;

/**
 * @author server
 *
 */
public class UserDetailDaoTest extends BaseDaoTestCase {
	@Autowired
	private UserDetailDao userDetDao;
	
	@Test
	public void getUserByUserid() throws Exception{
		UserDetail userDet= userDetDao.getUserDetailById(1l);
		
	}
}
