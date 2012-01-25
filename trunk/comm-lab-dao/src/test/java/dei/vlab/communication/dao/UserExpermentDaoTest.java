/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Experiment;
import dei.vlab.communication.model.UserExperment;

/**
 * @author server
 *
 */

public class UserExpermentDaoTest  extends BaseDaoTestCase{
	@Autowired
	private UserExpermentDao userExpDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CircuitDao cirDao;
	
	
	/// test  case for inserting value in the experiment table user table and circuit table..///
	
	@Test
	@Rollback(false)
	public void testuserExperimentSaveValue(){
		
		// User Experiment object //
		UserExperment userExperiment=new  UserExperment();
		
		Experiment expData = new Experiment();
		expData.setConfig_properties("confg propetrties123");
		expData.setName("image file");
		expData.setInmage_file("experiment test123");
		expData.setNode_coordinate("node coordinate123");
		expData.setType("testing123");
		userExperiment.setExperiment(expData);
		
		// for circuit information //
		
		userExperiment.setCircuits(cirDao.get(1L));
		System.out.println("Circuit infromation "+cirDao.get(1L));
		
		// for user information in the userdetail dao//
		userExperiment.setUsers(userDao.get(3L));
		System.out.println("user infrmation "+userDao.get(3L));
		
		// user data //
		userExpDao.save(userExperiment);
		
		assertNotNull(userExperiment);
		
		System.out.println("experiment date "+userExperiment.getExperiment());
		UserExperment allData= userExpDao.findUserExperimentById(1L);		
		System.out.println("hiii"+allData);
		
		flush();
		
		
	}
	
	// get all experiment date by the user id//
	@Test
	public void testUserExperimentById(){
		UserExperment getuserExpData= userExpDao.findUserExperimentById(1L);
		assertNotNull(getuserExpData);
		System.out.println("User Experiment data "+getuserExpData);
	}

	// delete user experiment by id //
	@Test
	public void testDeletUserExperiment(){
		System.out.println("Delete Experiment");
		userExpDao.deleteUserExperimentById(1L);
		flush();
	}
	
}
