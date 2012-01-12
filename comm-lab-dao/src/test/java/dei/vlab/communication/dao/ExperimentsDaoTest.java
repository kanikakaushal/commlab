package dei.vlab.communication.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author server
 * 
 */
public class ExperimentsDaoTest extends BaseDaoTestCase {
    @Autowired
    private ExperimentsDao expDao;

    @Test
    public void getTestInviladeExperiment() throws Exception {
        // Experiment exp = expDao.getExperimentByName("goutam");
    }

    @Test
    public void getTestExperimentById() throws Exception {
        // Experiment expbyid = expDao.getExperimentById(1l);

    }

}