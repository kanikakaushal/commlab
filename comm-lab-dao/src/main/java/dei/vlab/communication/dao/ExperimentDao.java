/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.model.Experiment;

/**
 * @author server
 * 
 */

public interface ExperimentDao extends GenericDao<Experiment, Long> {

    /*
     * Find Circuit by id from circuit table into the database.
     */

    Experiment findExperimentById(Long id);

    /*
     * Find All list of the circuit from circuit table into the database
     */
    List findAllExperiment();

    /*
     * Find Circuit by Circuit name from circuit table into database
     */
    List findExperimentByName(String name);

    /*
     * Save circuit into database in circuit table.
     */
    Experiment saveExperiment(Experiment experiment);

    /*
     * Delete circuit circuit table from the database
     */
    void deletExperimentById(Long id);

}
