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
        if (log.isDebugEnabled()) {
            log.debug("experment's id: " + id);
        }
        getHibernateTemplate().saveOrUpdate(id);
        return null;
    }

    public List findAllExperiment() {
        List experimentList = null;
        experimentList = getHibernateTemplate().find("from Experment");
        if (experimentList.isEmpty()) {
            return null;
        }
        return experimentList;
    }

    public Experiment updateExperimentById(Long id) {
        List experimentId = getHibernateTemplate().find("from Experiment where name=?", id);
        if (experimentId.isEmpty()) {
            return null;
        } else {
            return (Experiment) experimentId.get(0);
        }
    }

    public void deleteExperimentById(Long id) {
        Object delObj = getHibernateTemplate().load(Experiment.class, id);
        if (delObj != null) {
            getHibernateTemplate().delete(delObj);
        }
    }

}
