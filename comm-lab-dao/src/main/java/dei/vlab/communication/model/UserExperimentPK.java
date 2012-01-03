/*
 * $Id$
 * Copyright (c) Dayalbagh Educational Institute
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute.
 *
 */

package dei.vlab.communication.model;

import javax.persistence.Embeddable;

/**
 * This class is a primary key for the user_experiment table.
 * 
 * @version $Revision$ $Date$
 * @author kaushkan
 */
@Embeddable
public class UserExperimentPK extends BaseObject {
    private static final long serialVersionUID = -9141354623425013763L;

    private Long userPK;
    private Long experimentPK;
    private Long circuitPK;

    public Long getUserPK() {
        return userPK;
    }

    public void setUserPK(Long userPK) {
        this.userPK = userPK;
    }

    public Long getExperimentPK() {
        return experimentPK;
    }

    public void setExperimentPK(Long experimentPK) {
        this.experimentPK = experimentPK;
    }

    public Long getCircuitPK() {
        return circuitPK;
    }

    public void setCircuitPK(Long circuitPK) {
        this.circuitPK = circuitPK;
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
