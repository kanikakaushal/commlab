/**
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
 * @author server
 *
 */
@Entity
@Table(name="circuit_privileges")
public class CircuitPrivileges extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CPid")
	private Long circuitPrivilegesId;
	@Column(name="name",nullable=false,length=100)
	private String name;
	@Column(name="description",nullable=false,length=200)
	private String description;
	
	
	public Long getCircuitPrivilegesId() {
		return circuitPrivilegesId;
	}

	public void setCircuitPrivilegesId(Long circuitPrivilegesId) {
		this.circuitPrivilegesId = circuitPrivilegesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * 
	 */
	public CircuitPrivileges() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
