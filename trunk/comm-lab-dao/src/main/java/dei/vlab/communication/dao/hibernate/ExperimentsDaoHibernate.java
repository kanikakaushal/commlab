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

    public Experiment findExperimentByName(String name) {
        List experiment = getHibernateTemplate().find("from Experiment where name=?", name);
        if (experiment.isEmpty()) {
            return null;
        } else {
            return (Experiment) experiment.get(0);
        }
    }

    public Experiment findExperimentById(Long id) {
    	 List experimentId = getHibernateTemplate().find("from Experiment where id=?", id);
         if (experimentId.isEmpty()) {
             return null;
         } else {
             return (Experiment) experimentId.get(0);
         }
    	
    	
       
    }

    public List findAllExperiment() {
        List experimentList = null;
        experimentList = getHibernateTemplate().find("from Experiment");
        if (experimentList.isEmpty()) {
            return null;
        }
        return experimentList;
    }

    public Experiment saveExperimentById(Long id) {
    	 if (log.isDebugEnabled()) {
             log.debug("experment's id: " + id);
         }
         getHibernateTemplate().saveOrUpdate(id);
         return null;
    }

    public void deleteExperimentById(Long id) {
        Object delObj = getHibernateTemplate().load(Experiment.class, id);
        if (delObj != null) {
            getHibernateTemplate().delete(delObj);
        }
    }

}
