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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class represents a circuit.
 * 
 * @version $Revision$ $Date$
 * @author kaushkan
 */
@Entity
@Table(name = "circuit")
public class Circuit extends BaseObject {
    private static final long serialVersionUID = 6858812338686629140L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long circuitId;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @Column(length = 30)
    private String type;

    public Long getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(Long circuitId) {
        this.circuitId = circuitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.circuitId).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDetail)) {
            return false;
        }

        final Circuit circuitUser = (Circuit) o;

        return circuitId != null ? circuitId.equals(circuitUser.getCircuitId()) : circuitUser.getCircuitId() == null;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return (circuitId != null ? circuitId.hashCode() : 0);
    }

}
