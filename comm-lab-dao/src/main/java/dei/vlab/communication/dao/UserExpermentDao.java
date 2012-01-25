/**
 * 
 */
package dei.vlab.communication.dao;

import dei.vlab.communication.model.UserExperment;

/**
 * @author server
 *
 */
public interface UserExpermentDao extends GenericDao<UserExperment, Long>{
	
	/*
	 * Find user experiment by id
	 */
	
	UserExperment findUserExperimentById(Long id);
	
	/*
	 * save and update  user experiment 
	 */
	
	UserExperment saveUserExperiment(UserExperment userExperiment);
	
	/*
	 *  Delete user experiment ..
	 */

	void deleteUserExperimentById(Long id);
}
