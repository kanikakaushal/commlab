package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import dei.vlab.communication.model.User;

public class UserDaoTest extends BaseDaoTestCase {
    @Autowired
    private UserDao dao;
   

    @Test
    @ExpectedException(DataAccessException.class)
    public void testGetUserInvalid() throws Exception {
        // should throw DataAccessException
        dao.get(100L);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = dao.get(1L);
        assertNotNull(user);
    }

    @Test
    public void testGetUserPassword() throws Exception {
        User user = dao.get(1L);
        String password = dao.getUserPassword(user.getUsername());
        assertNotNull(password);
        log.debug("password: " + password);
    }
    
    @Test
    public void testSaveUser() {
    	User test = new User();
    	//test.setId(3L);
    	test.setPassword("gotuam");
    	test.setStatus("ACTIVE");
    	test.setUsername("user");
    	
    	//dao.saveUser(test);
		//assertNotNull("hii", save);
		
    }

}
