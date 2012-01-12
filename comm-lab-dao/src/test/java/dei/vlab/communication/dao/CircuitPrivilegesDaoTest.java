/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author server
 * 
 */
public class CircuitPrivilegesDaoTest extends BaseDaoTestCase {

    @Autowired
    private CircuitPrivilegesDao cirPrivDao;

    @Test
    public void testCircuitByName() throws Exception {
        List cirPrev = cirPrivDao.findPrivilegeByName("full wave");
        // assertNotNull(cirPrev);
        // assertNotNull(cirPrev.getName());
        // assertNotNull(cirPrev.getDescription());
    }

    @Test
    public void testSavePrivlage() {
        // CircuitPrivileges prev = new CircuitPrivileges();
        // prev.setId(1l);
        // prev.setDescription("simulate");
        // prev.setName("full wave");
        // cirPrivDao.savePrivilage(prev);
    }
}
