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
 * This class is a primary key for the circuit_privilege table.
 * 
 * @version $Revision$ $Date$
 * @author kaushkan
 */
@Embeddable
public class CircuitPrivilegePK extends BaseObject {
    private static final long serialVersionUID = -7327041794430538331L;

    private Long circuitPK;
    private Long rolePK;
    private Long operationPK;

    public Long getCircuitPK() {
        return circuitPK;
    }

    public void setCircuitPK(Long circuitPK) {
        this.circuitPK = circuitPK;
    }

    public Long getRolePK() {
        return rolePK;
    }

    public void setRolePK(Long rolePK) {
        this.rolePK = rolePK;
    }

    public Long getOperationPK() {
        return operationPK;
    }

    public void setOperationPK(Long operationPK) {
        this.operationPK = operationPK;
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
