/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.Experiment;

/**
 * @author server
 *
 */
public interface ExperimentsDao extends GenericDao<Experiment, Long> {
	/*
	 * get user experiment from database 
	 */
	Experiment getExperimentByName(String ExperimentName);
	/*
	 *  Get Experiment by experiment Id
	 */
	Experiment getExperimentById(Long expermentId);
	
	/*
	 * Get all experiment in the Experiment table .
	 * 
	 */
	List getExperiment();
	/*
	 * save and update experiment 
	 */
	Experiment updateExperiment(Long experimentId);
	/*
	 * delete experiment from the database by name
	 */
	void deleteExperiment(Long experimentId);
	

}
