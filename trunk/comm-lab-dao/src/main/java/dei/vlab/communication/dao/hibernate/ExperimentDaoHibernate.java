/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.ExperimentDao;
import dei.vlab.communication.model.Experiment;

/**
 * @author server
 * 
 */
@Repository
public class ExperimentDaoHibernate extends GenericDaoHibernate<Experiment, Long> implements ExperimentDao {

    /**
	 * 
	 */
    public ExperimentDaoHibernate() {
        super(Experiment.class);
    }

    public Experiment findExperimentById(Long id) {
        List experiment = null;
        experiment = getHibernateTemplate().find("from Experiment where id=?", id);
        if (experiment.isEmpty()) {
            return null;
        }
        return (Experiment) experiment.get(0);
    }

    public List findAllExperiment() {
        List experimentList = null;
        experimentList = getHibernateTemplate().find("from Experiment");
        if (experimentList.isEmpty()) {
            return null;
        }
        return experimentList;
    }

    public List findExperimentByName(String name) {
        List experiment = null;
        experiment = getHibernateTemplate().find("from Experiment where name=?", name);
        if (experiment == null) {
            return null;
        }
        return experiment;
    }

    public void deletExperimentById(Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Delete circuit id " + id);
        }
        Object deletObject = getHibernateTemplate().load(Experiment.class, id);
        if (deletObject != null) {
            getHibernateTemplate().delete(deletObject);
        }

    }

    public Experiment saveExperiment(Experiment experiment) {
        if (log.isDebugEnabled()) {
            log.debug("save and update " + experiment);
        }
        getHibernateTemplate().saveOrUpdate(experiment);
        return experiment;
    }

}
