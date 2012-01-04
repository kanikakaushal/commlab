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
public class UserRolePk  extends BaseObject{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userRoleUserIdPk;
	 private Long userRoleRoleIdPk;
	 
	 public Long getUserRoleUserIdPk() {
		return userRoleUserIdPk;
	}
	public void setUserRoleUserIdPk(Long userRoleUserIdPk) {
		this.userRoleUserIdPk = userRoleUserIdPk;
	}
	public Long getUserRoleRoleIdPk() {
		return userRoleRoleIdPk;
	}
	public void setUserRoleRoleIdPk(Long userRoleRoleIdPk) {
		this.userRoleRoleIdPk = userRoleRoleIdPk;
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
