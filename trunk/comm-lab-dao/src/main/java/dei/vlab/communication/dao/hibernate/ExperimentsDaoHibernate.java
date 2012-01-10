/**
 * 
 */
package dei.vlab.communication.dao.hibernate;



import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.ExperimentsDao;
import dei.vlab.communication.model.Experiment;

/**
 * @author server
 *
 */
@Repository
public class ExperimentsDaoHibernate extends GenericDaoHibernate<Experiment, Long> implements ExperimentsDao {

	/**
	 * 
	 */
	public ExperimentsDaoHibernate() {
		super(Experiment.class);
	}

	public Experiment getExperimentByName(String ExperimentName) {
		System.out.println("starting Experiment");
		List experiment= getHibernateTemplate().find("from Experiment where name=?",ExperimentName);
		if(experiment.isEmpty()){
			return null;
		}else{
			return (Experiment) experiment.get(0);
		}
	}

	public Experiment updateExperiment(Long experimentId) {
		 if (log.isDebugEnabled()) {
	            log.debug("experment's id: " + experimentId);
	        }
	        getHibernateTemplate().saveOrUpdate(experimentId);
	        // necessary to throw a DataIntegrityViolation and catch it in UserManager
	        getHibernateTemplate().flush();
	        return null;
	}

	public void deleteExperiment(Long experimentId) {
		try {
			Object o = getHibernateTemplate().load(Experiment.class, experimentId);
			if(o!=null){
				getHibernateTemplate().delete(o);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Experiment getExperimentById(Long expermentId) {
		Experiment expriment=null;
		try {
			System.out.println("hii i am in the Experment logggg>>>");
			expriment=getHibernateTemplate().load(Experiment.class, expermentId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return expriment;
		}

	public List getExperiment() {
		List experimentList = null;
		try {
			experimentList=getHibernateTemplate().find("from Experment");
			if(experimentList.isEmpty()){
				return null;
			}
		} catch (Exception e) {
			
		}
		return experimentList;
	}
	

}
