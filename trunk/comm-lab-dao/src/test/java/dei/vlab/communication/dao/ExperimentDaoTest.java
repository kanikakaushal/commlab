package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.model.Experiment;
import dei.vlab.communication.model.User;

public class ExperimentDaoTest extends BaseDaoTestCase {
    @Autowired
    private ExperimentDao expDao1;
    @Autowired
    private CircuitDao cirDao;
    @Autowired
    private UserDao userDao;

    @Test
    @Rollback(false)
    public void testSaveExperiment() {
        // Experiment data object //
        Experiment circuitDetail = new Experiment();
        circuitDetail.setRemark("exe");
        circuitDetail.setType("transister_based");
        circuitDetail.setConfigProperties("pushpullnode_config");
        circuitDetail.setImageFile("pushpull.png");
        circuitDetail.setName("Push_pull");
        circuitDetail.setNoceCordinate("testcordinate");
        // Circuit detail //
        Circuit circuitDetail1 = cirDao.findCircuitById(1L);
        circuitDetail.setCircuits(circuitDetail1);
        // User detail //
        User userData = userDao.get(1L);
        circuitDetail.setUsers(userData);
        // save all things //
        expDao1.saveExperiment(circuitDetail);
        assertNotNull(expDao1);

    }

    // Test to find circuit in the experiment table by id//
    @Test
    public void testGetExperimentById() {
        Experiment expData = expDao1.findExperimentById(1L);
        // assertNotNull(expData);
        System.out.println("Experiment data User id 1" + expData);
    }

    //
    @Test
    public void testGetAllExperiment() {
        List allExpData = expDao1.findAllExperiment();
        System.out.println("All data" + allExpData);
    }

}
