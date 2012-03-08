/**
 * 
 */
package dei.vlab.communication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author server
 * 
 */
@Entity
@Table(name = "role")
public class Role extends BaseObject implements Serializable, GrantedAuthority {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_BEGINNER = "ROLE_BEGINNER";
	public static final String ROLE_MODERATE = "ROLE_MODERATE";
	public static final String ROLE_EXPERT = "ROLE_EXPERT";

	public static final String USER_TYPE_ADMIN = "ADMIN";
	public static final String USER_TYPE_USER = "USER";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String type;
	private String description;

	/**
	 * 
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}
    /**
     * Create a new instance and set the name.
     *
     * @param name name of the role.
     */
    public Role(final String name) {
        this.name = name;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(length = 64, nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 100, nullable = false)
	public String getType() {
		return type;
	}

	@Column(nullable = false, length = 200)
	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
		.append(getAuthority()).toString();

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Role)) {
			return false;
		}

		final Role role = (Role) o;

		return !(name != null ? !name.equals(role.name) : role.name != null);

	}

	@Override
	public int hashCode() {
		return (name != null ? name.hashCode() : 0);

	}

	/**
	 * {@inheritDoc}
	 */
	public int compareTo(Object o) {
		return (equals(o) ? 0 : -1);
	}

	/**
	 * @return the name property (getAuthority required by Acegi's
	 *         GrantedAuthority interface)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Transient
	public String getAuthority() {
		if(getType().equalsIgnoreCase(USER_TYPE_ADMIN)){
			return "ROLE_ADMIN";
		}
		return "ROLE_USER";
	}

}
