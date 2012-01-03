/*
 * $Id$
 * Copyright (c) Dayalbagh Educational Institute
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute.
 *
 */

package dei.vlab.communication.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * This class represents the privilege associated with a circuit based on the role and operation matrix.
 * 
 * @version $Revision$ $Date$
 * @author kaushkan
 */
@Entity
@Table(name = "circuit_privilege")
public class CircuitPrivilege extends BaseObject {
    private static final long serialVersionUID = 6486518925984698462L;

    @EmbeddedId
    private CircuitPrivilegePK id;

    @MapsId("circuitPK")
    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuit circuit;

    @MapsId("rolePK")
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @MapsId("operationPK")
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private CircuitOperation operation;

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public CircuitOperation getOperation() {
        return operation;
    }

    public void setOperation(CircuitOperation operation) {
        this.operation = operation;
    }

    public void setId(CircuitPrivilegePK id) {
        this.id = id;
    }

    public CircuitPrivilegePK getId() {
        return id;
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
