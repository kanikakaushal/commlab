/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.UserExpermentDao;
import dei.vlab.communication.model.UserExperment;

/**
 * @author server
 */
@Repository
public class UserExpermentDaoHibernate extends GenericDaoHibernate<UserExperment, Long> implements UserExpermentDao{

	/**
	 * 
	 */
	public UserExpermentDaoHibernate() {
		super(UserExperment.class);
		
	}

	public UserExperment findUserExperimentById(Long id) {
		List userExperiment=null;
		 userExperiment=getHibernateTemplate().find("from UserExperment where id=?", id);
		 if(userExperiment==null){
			 return null;
		 }
		return (UserExperment) userExperiment.get(0);
	}

	public UserExperment saveUserExperiment(UserExperment userExperiment) {
		getHibernateTemplate().saveOrUpdate(userExperiment);
		return userExperiment;
	}

	public void deleteUserExperimentById(Long id) {
		Object delUserExpObject=getHibernateTemplate().load(UserExperment.class, id);
		if(delUserExpObject!=null){
			getHibernateTemplate().delete(delUserExpObject);
		}
		
	}

}
