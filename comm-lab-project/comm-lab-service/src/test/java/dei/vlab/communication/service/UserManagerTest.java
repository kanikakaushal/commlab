package dei.vlab.communication.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.model.UserDetail;

public class UserManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(UserManagerTest.class);
    @Autowired
    private UserManager mgr;
    @Autowired
    private RoleManager roleManager;
    private User user;
    @Autowired

    @Test
    public void testGetUser() throws Exception {
        user = mgr.getUserByUsername("user");
        assertNotNull(user);
        
        log.debug(user);
        assertEquals(1, user.getRoles().size());
    }

    @Test
    public void testSaveUser() throws Exception {
        user = mgr.getUserByUsername("user");
        assertEquals(1, user.getRoles().size());
        user = mgr.saveUser(user);
         assertEquals(1, user.getRoles().size());
    }

    @Test
    public void testAddAndRemoveUser() throws Exception {
        user = new User();

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (User) populate(user);
        Role role= roleManager.getRole(Role.ROLE_BEGINNER);
        log.info("Adding new Role "+role);
        log.info("user information"+user);
        user.addRole(role);
        UserDetail userDetail= new UserDetail();
        userDetail = (UserDetail) populate(userDetail);
        user.setUserDetail(userDetail);
        log.info("user Detail information"+userDetail);
        user = mgr.saveUser(user);
        assertEquals("john", user.getUsername());
        assertEquals(1, user.getRoles().size());

        log.debug("removing user...");

        mgr.removeUser(user.getId().toString());

        try {
            user = mgr.getUserByUsername("john");
            fail("Expected 'Exception' not thrown");
        } catch (Exception e) {
            log.debug(e);
            assertNotNull(e);
        }
    }
}
