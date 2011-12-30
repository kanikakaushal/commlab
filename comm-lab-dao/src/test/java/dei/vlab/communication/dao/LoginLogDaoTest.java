package dei.vlab.communication.dao;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import dei.vlab.communication.model.LoginLog;
public class LoginLogDaoTest extends BaseDaoTestCase{
	
	private LoginLogDao llDao;
	@Test
	    public void testGetLog() throws Exception {
	        LoginLog logUser = llDao.get(1l);

	        assertNotNull(logUser);
	    }
}
