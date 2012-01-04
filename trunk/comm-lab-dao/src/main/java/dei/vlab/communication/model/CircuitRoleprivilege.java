/**
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
 * @author server
 *
 */
@Entity
@Table(name="circuit_role_privilege")
public class CircuitRoleprivilege {
	
	@EmbeddedId
	private CircuitRolePrivilegePk id;
	
	@MapsId("circuitRolePrivilegeCircuitIdPk")
	@ManyToOne
	@JoinColumn(name="circuit_id")
	private Circuit circuitId;
	@MapsId("circuitRolePrivilegeRightIdPk")
	@ManyToOne
	@JoinColumn(name="right_id")
	private CircuitPrivileges circuitprivlegeId;
	
	@MapsId("circuitRolePrivilegeRoleIdPk")
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role roleId;
	

	/**
	 * 
	 */
	public CircuitRoleprivilege() {
		// TODO Auto-generated constructor stub
	}
	public CircuitRolePrivilegePk getId() {
		return id;
	}


	public void setId(CircuitRolePrivilegePk id) {
		this.id = id;
	}


	public Circuit getCircuitId() {
		return circuitId;
	}


	public void setCircuitId(Circuit circuitId) {
		this.circuitId = circuitId;
	}


	public CircuitPrivileges getCircuitprivlegeId() {
		return circuitprivlegeId;
	}


	public void setCircuitprivlegeId(CircuitPrivileges circuitprivlegeId) {
		this.circuitprivlegeId = circuitprivlegeId;
	}


	public Role getRoleId() {
		return roleId;
	}


	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}




}
