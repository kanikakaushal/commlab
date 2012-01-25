/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.CircuitPrivileges;

/**
 * @author server
 * 
 */
public class CircuitPrivilegesDaoTest extends BaseDaoTestCase {

    @Autowired
    private CircuitPrivilegesDao cirPrivDao;

  // insert circuit privilege //

    @Test
    @Rollback(false)
    public void testSavePrivlage() {
         CircuitPrivileges prev = new CircuitPrivileges();
         CircuitPrivileges prev1 = new CircuitPrivileges();
        // prev.setId(1l);
         prev.setDescription("simulate");
         prev.setName("full_wave");
         cirPrivDao.savePrivilage(prev);
         
         prev1.setName("test");
         prev1.setDescription("execuite");
         cirPrivDao.savePrivilage(prev1);
         assertNotNull(prev.getId());
         flush();
         
    }
    
    // test circuit privilege by id//
    
    @Test
    public void testCircuitById() throws Exception {
        CircuitPrivileges cirPrevId = cirPrivDao.findprivilegesById(1L);
         assertNotNull(cirPrevId);
         System.out.println("test for Privalge by id "+cirPrevId);
    }
 // test circuit privilege by name//
    
    @Test
    public void testCircuitByName() throws Exception {
        CircuitPrivileges cirPrevName = cirPrivDao.findPrivilegeByName("properties");
         assertNotNull(cirPrevName);
         System.out.println("test for Privalge by name "+cirPrevName);
    }
}
