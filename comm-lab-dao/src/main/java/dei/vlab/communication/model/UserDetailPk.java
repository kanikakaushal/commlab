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
public class UserDetailPk extends BaseObject {
	private Long userDetailuseIdPk;

	public Long getUserDetailuseIdPk() {
		return userDetailuseIdPk;
	}

	public void setUserDetailuseIdPk(Long userDetailuseIdPk) {
		this.userDetailuseIdPk = userDetailuseIdPk;
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
