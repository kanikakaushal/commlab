/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Role;

/**
 * @author server
 * 
 */
public class RolesDaoTest extends BaseDaoTestCase {
    @Autowired
    private RolesDao roleDao;

    @Test
    @Ignore
    public void testGetRoleInvalid() throws Exception {
        Role role = roleDao.findRoleByName("ROLE_ADMIN");
        assertNotNull(role);

    }

    @Test
    @Rollback(false)
    public void testSaveRole() throws Exception {
        Role rolesave = new Role();
        rolesave.setDescription("Administrator");
        rolesave.setName("ROLE_ADMIN");
        rolesave.setType("ADMIN");
        roleDao.save(rolesave);
        assertNotNull(rolesave);

        Role roleBeginner = new Role();
        roleBeginner.setDescription("User");
        roleBeginner.setName("ROLE_BEGINNER");
        roleBeginner.setType("USER");

        roleDao.save(roleBeginner);
        assertNotNull(rolesave);
    }

    @Test
    @Ignore
    public void testGetRoleById() {
        Role role = roleDao.findRoleById(1L);
        assertNotNull(role);
        assertNotNull("role", role.getName());
    }
}
