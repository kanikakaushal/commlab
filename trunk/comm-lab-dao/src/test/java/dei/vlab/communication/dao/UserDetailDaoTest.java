/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.UserDetail;

/**
 * @author server
 * 
 */
public class UserDetailDaoTest extends BaseDaoTestCase {
    @Autowired
    private UserDetailDao userDetDao;

    @Test
    @Ignore
    public void getFindeUserDetailById() throws Exception {
        UserDetail userDetail = userDetDao.findeUserDetailById(1l);
        assertNotNull(userDetail);
    }

    @Test
    @Ignore
    public void testFindeUserByFirstName() {
        UserDetail userDetail = userDetDao.findeUserDetailByFirstName("user1_fn");
        assertNotNull(userDetail);
    }

    @Test
    @Rollback(false)
    @Ignore
    public void testMessageInsert() {

    }
}
