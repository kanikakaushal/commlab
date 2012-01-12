/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Role;

/**
 * @author server
 * 
 */
public class RolesDaoTest extends BaseDaoTestCase {
    @Autowired
    private RolesDao roleDao;

    @Test
    public void testGetRoleInvalid() throws Exception {
        Role role = roleDao.findRoleByName("ROLE_ADMIN");
        assertNotNull(role);

    }

    @Test
    public void testSaveRole() throws Exception {
        // Role rolesave ;
        // rolesave.setDescription("Administrator");
        // rolesave.setName("ROLE_ADMIN");
        // rolesave.setType("USER");
        // roleDao.save(rolesave);
        // assertNotNull(rolesave);

    }

    @Test
    public void testGetRoleById() {
        Role role = roleDao.findRoleById(1L);
        assertNotNull(role);
        assertNotNull("role", role.getName());
    }

}
