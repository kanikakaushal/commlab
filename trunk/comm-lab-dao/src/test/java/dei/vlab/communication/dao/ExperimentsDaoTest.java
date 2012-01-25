package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Experiment;

/**
 * @author server
 */
public class ExperimentsDaoTest extends BaseDaoTestCase {
    @Autowired
    private ExperimentsDao expDao;

    @Test
    @Rollback(false)
    public void tetsSaveDataExperiment(){
    	Experiment expData= new Experiment();
    	expData.setConfig_properties("configuration propertyes");
    	expData.setInmage_file("filename");
    	expData.setName("test");
    	expData.setNode_coordinate("node cordinate");
    	expData.setType("testtype");
    	expDao.save(expData);
    	System.out.println("save data in Experiment table");
    	flush();
    }
    // find all experiment by id //
    @Test
    public void getTestExperimentById() throws Exception {
         Experiment expbyid = expDao.findExperimentById(1L);
         assertNotNull(expbyid);
         System.out.println("Experiment data by id"+expbyid);
    }

    // find all experiment by name //
    @Test
    public void getTestExperimentByName() throws Exception {
         Experiment expbyName = expDao.findExperimentByName("test");
         assertNotNull(expbyName);
         System.out.println("Experiment data by name"+expbyName);
    }
    // find all information in to Experiment table // 
    @Test
    public void getTestExperimentAllinfo() throws Exception {
         List allInfoExp = expDao.getAll();
         assertNotNull(allInfoExp);
         System.out.println("Experiment data All "+allInfoExp);
    }
}