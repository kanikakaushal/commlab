/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.model.Role;

/**
 * @author server
 * 
 */
public class CircuitDaoTest extends BaseDaoTestCase {
    @Autowired
    private CircuitDao cDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    @Rollback(false)
    public void tetsSaveCircuit() {

        Circuit circuitDetail = new Circuit();
        circuitDetail.setDescription("exe");
        circuitDetail.setType("transister_based");
        circuitDetail.setConfigProperties("pushpullnode_config");
        circuitDetail.setImageFile("pushpull.png");
        circuitDetail.setName("Push_pull");
        circuitDetail.setNoceCordinate("testcordinate");

        Role role = new Role();
        role.setName("gotuam");
        role.setType("admin");
        role.setDescription("beginer");

        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        // assertNotNull(role.getId());

        // CircuitPrivilege data entery //

     /*   CircuitPrivileges circuitPrivilegeData = new CircuitPrivileges();
        circuitPrivilegeData.setName("full wave");
        circuitPrivilegeData.setDescription("Excute");

        circuitDetail.setCircuitPrivilege(circuitPrivilegeData);
        circuitDetail.setRoles(roles);
*/
        // circuitDetail.setExperiments(expData1);

        cDao.saveCircuit(circuitDetail);
        // Assert.assertNotNull("id is circuit is",saveCircuit.getId());
        assertNotNull(circuitDetail.getId());
    }

    @Test
    public void testAllCircuit() throws Exception {
        Circuit circuit = cDao.findCircuitById(1L);
        assertNotNull(circuit);
    }

    @Test
    public void testListAllCircuit() {
        List allCircuit = cDao.findAllCircuit();
        assertNotNull(allCircuit);
        System.out.println("all circuit " + allCircuit);
    }

    @Test
    public void testCircuitByName() {
        Circuit circuit = cDao.findCircuitByName("Push_pull");
        assertNotNull(circuit);

        System.out.println("find circuit by name" + circuit);
    }

    @Test
    public void testCircuitById() {
        Circuit circuitById = cDao.findCircuitById(1L);
        assertNotNull(circuitById);

        System.out.println("find circuit by id" + circuitById);
    }

    @Test
    public void tetsDeleteCircuit() throws Exception {
        cDao.deletCircuitById(1L);
        System.out.println("Delete ");

    }

}
