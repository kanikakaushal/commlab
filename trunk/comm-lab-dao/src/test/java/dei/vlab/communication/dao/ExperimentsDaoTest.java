package dei.vlab.communication.dao;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Experiment;

/**
 * @author server
 *
 */
public class ExperimentsDaoTest extends BaseDaoTestCase {
	@Autowired
	private ExperimentsDao expDao;
	
	@Test
	public void getTestInviladeExperiment() throws Exception{
		Experiment exp= expDao.getExperimentByName("goutam");
	}
	
	@Test
	public void getTestExperimentById() throws Exception{
		Experiment expbyid= expDao.getExperimentById(1l);
		
	}

}