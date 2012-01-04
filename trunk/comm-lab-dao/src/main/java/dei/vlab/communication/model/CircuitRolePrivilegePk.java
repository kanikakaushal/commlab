/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Embeddable;

/**
 * @author server
 *
 */
@Embeddable
public class CircuitRolePrivilegePk extends BaseObject {

	private Long circuitRolePrivilegeCircuitIdPk;
	private Long circuitRolePrivilegeRightIdPk;
	private Long circuitRolePrivilegeRoleIdPk;
	
	public Long getCircuitRolePrivilegeCircuitIdPk() {
		return circuitRolePrivilegeCircuitIdPk;
	}
	public void setCircuitRolePrivilegeCircuitIdPk(
			Long circuitRolePrivilegeCircuitIdPk) {
		this.circuitRolePrivilegeCircuitIdPk = circuitRolePrivilegeCircuitIdPk;
	}
	public Long getCircuitRolePrivilegeRightIdPk() {
		return circuitRolePrivilegeRightIdPk;
	}
	public void setCircuitRolePrivilegeRightIdPk(Long circuitRolePrivilegeRightIdPk) {
		this.circuitRolePrivilegeRightIdPk = circuitRolePrivilegeRightIdPk;
	}
	public Long getCircuitRolePrivilegeRoleIdPk() {
		return circuitRolePrivilegeRoleIdPk;
	}
	public void setCircuitRolePrivilegeRoleIdPk(Long circuitRolePrivilegeRoleIdPk) {
		this.circuitRolePrivilegeRoleIdPk = circuitRolePrivilegeRoleIdPk;
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
