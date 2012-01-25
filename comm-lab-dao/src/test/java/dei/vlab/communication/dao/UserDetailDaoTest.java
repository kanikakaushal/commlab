/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Message;
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
    
    @Test
    @Ignore
    @Rollback(false)
    public void testMessageInsert(){
    	Message messageData= new Message();
    	messageData.setCcc("valb.co.in cc");
    	messageData.setStatus("test status");
    	messageData.setSubject("test messages");
    	messageData.setToo("evalicate.freehostia@gamil.com");
    	
    	UserDetail userDetail=null;
    	//userDetail.setMessages(messageData);
    	userDetDao.saveUserDetail(userDetail);
    	System.out.println("user detail"+userDetail);
    	
    }
}
