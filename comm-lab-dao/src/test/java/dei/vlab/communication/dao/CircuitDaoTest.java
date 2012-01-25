/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Circuit;

/**
 * @author server
 * 
 */
public class CircuitDaoTest extends BaseDaoTestCase {
    @Autowired
    private CircuitDao cDao;

    @Test
    @Ignore
    public void testAllCircuit() throws Exception {
        List circuit = cDao.findCircuitById(1L);
        assertNotNull(circuit);
    }

   
  
    @Test
    @Rollback(false)
    public void tetsSaveCircuit() {
        Circuit circuitDetail = new Circuit();
        circuitDetail.setRemark("exe");
        circuitDetail.setType("transister_based");
        circuitDetail.setConfigProperties("pushpullnode_config");
        circuitDetail.setImageFile("pushpull.png");
        circuitDetail.setName("Push_pull");
        circuitDetail.setNoceCordinate("testcordinate");
        
        cDao.saveCircuit(circuitDetail);
       // Assert.assertNotNull("id is circuit is",saveCircuit.getId());
        assertNotNull(circuitDetail.getId());
    }

  
    @Test
    public void testListAllCircuit() {
        List allCircuit = cDao.findAllCircuit();
        assertNotNull(allCircuit);
        System.out.println("all circuit "+allCircuit);
    }

    @Test
    public void testCircuitByName() {
        List circuitName = cDao.findCircuitByName("Push_pull");
        assertNotNull(circuitName);
        
        System.out.println("find circuit by name"+circuitName);
    }

    @Test
    public void testCircuitById() {
        List circuitById = cDao.findCircuitById(3L);
        assertNotNull(circuitById);
        
        System.out.println("find circuit by id"+circuitById);
    }

    @Test
    public void tetsDeleteCircuit() throws Exception{
        cDao.deletCircuitById(1L);
        System.out.println("Delete ");
        
    }
   
}
