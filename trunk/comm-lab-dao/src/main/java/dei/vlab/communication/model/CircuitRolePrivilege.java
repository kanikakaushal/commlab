/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author server
 *
 */
@Entity
@Table(name="circuit_role_privilege")
public class CircuitRolePrivilege extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="circuit_id")
	private Circuit circuit;
	@ManyToOne
	@JoinColumn(name="right_id")
	private CircuitPrivileges circuitPid;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	
	/**
	 * 
	 */
	public CircuitRolePrivilege() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Circuit getCircuit() {
		return circuit;
	}


	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}


	public CircuitPrivileges getCircuitPid() {
		return circuitPid;
	}


	public void setCircuitPid(CircuitPrivileges circuitPid) {
		this.circuitPid = circuitPid;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
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
