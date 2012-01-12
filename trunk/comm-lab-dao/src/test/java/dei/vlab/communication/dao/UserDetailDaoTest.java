/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

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
    public void getUserByUserid() throws Exception {
        UserDetail userDet = userDetDao.findeUserById(1l);
        assertNotNull(userDet);
        // assertNotNull(userDet.getAddress1());
        // assertNotNull(userDet.getAddress2());
    }

    @Test
    public void testFindeUserInId() {
        UserDetail userd = userDetDao.findeUserByName("goutam");
        assertNotNull(userd);
        // assertNotNull(userd.getCollege_name());
    }
}
