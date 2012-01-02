/*
 * $Id$
 * Copyright (c) Dayalbagh Educational Institute
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute.
 *
 */

package dei.vlab.communication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents an experiment.
 * 
 * @version $Revision$ $Date$
 * @author kaushkan
 */
@Entity
@Table(name = "experiment")
public class Experiment extends BaseObject {
    private static final long serialVersionUID = 7084767567952707609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long experimentId;
    @Column(nullable = false, length = 50, unique = true)
    private String experimentName;

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dei.vlab.communication.model.BaseObject#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dei.vlab.communication.model.BaseObject#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dei.vlab.communication.model.BaseObject#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
