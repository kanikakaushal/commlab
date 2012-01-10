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
@Table(name="user_role")
public class UserRole  extends BaseObject{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	/**
	 * 
	 */
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean equals(Object o) {
		return false;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
