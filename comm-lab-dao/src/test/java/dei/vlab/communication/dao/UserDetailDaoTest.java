package dei.vlab.communication.dao;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import dei.vlab.communication.model.UserDetail;

public class UserDetailDaoTest  extends BaseDaoTestCase{

	private UserDetailDao udDao;
	 @Test
	    public void testGetUserDetail() throws Exception {
	        UserDetail user = udDao.get(1L);
	        assertNotNull(user);
	    }
}
