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
     * Find user experiment by name from Experiment table
     */

    Experiment findExperimentByName(String name);

    /*
     * Get Experiment by experiment Id
     */

    Experiment findExperimentById(Long id);

    /*
     * Get all experiment in the Experiment table .
     */

    List findAllExperiment();

    /*
     * Save and update experiment
     */

    Experiment updateExperimentById(Long id);

    /*
     * Delete experiment from the database by name
     */

    void deleteExperimentById(Long id);

}
