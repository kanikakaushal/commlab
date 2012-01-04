/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author server
 *
 */
@Entity
@Table(name="user_role")
public class UserRole extends BaseObject {
	
	@EmbeddedId
	private Long userRoleId;
	@MapsId("userRoleUserIdPk")
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userId;
	@MapsId("userRoleRoleIdPk")
	@ManyToOne
	@JoinColumn(name="id")
	private Role roleId;
	
	
	/**
	 * 
	 */
	public UserRole() {
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
