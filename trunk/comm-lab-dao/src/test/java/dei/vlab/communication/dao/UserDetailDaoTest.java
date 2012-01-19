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
    public void getFindeUserDetailById() throws Exception {
        UserDetail userDetail = userDetDao.findeUserDetailById(1l);
        assertNotNull(userDetail);
    }

    @Test
    public void testFindeUserByFirstName() {
        UserDetail userDetail = userDetDao.findeUserDetailByFirstName("user1_fn");
        assertNotNull(userDetail);
    }
}
