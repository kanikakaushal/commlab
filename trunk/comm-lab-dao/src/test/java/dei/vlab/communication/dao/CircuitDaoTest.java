/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Circuit;

/**
 * @author server
 * 
 */
public class CircuitDaoTest extends BaseDaoTestCase {
    @Autowired
    private CircuitDao cDao;

    @Test
    public void testAllCircuit() throws Exception {
        List circuit = cDao.findCircuitById(1L);
        assertNotNull(circuit);
    }

    /* Spring problem
    @Test
    public void testListAllCircuit() {
        List allCircuit = cDao.findAllCircuit();
        assertNotNull(allCircuit);
    }

    @Test
    public void testCircuitByName() {
        Circuit circuitName = cDao.findCircuitByName("dei");
        assertNotNull(circuitName);

    }

    @Test
    public void tetsSaveCircuit() {
        Circuit saveCircuit = null;
        saveCircuit.setName("Push pull");
        saveCircuit.setImageFile("pushpull.png");
        saveCircuit.setNoceCordinate("2,3,5");
        cDao.saveCircuit(saveCircuit);
        Assert.assertNotNull("id is circuit is",saveCircuit.getId());
    }

    @Test
    public void tetsDeleteCircuit() throws Exception{
        cDao.deletCircuitById(1L);
        
    }
    */
}
