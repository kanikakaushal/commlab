package dei.vlab.communication.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
@XmlRootElement
public class User extends BaseObject implements Serializable, UserDetails {
	private static final long serialVersionUID = 3832626162173359411L;
	public static final String STATUS_APPROVED = "APPROVED";
	public static final String STATUS_PENDING = "PENDING";
	public static final String STATUS_REJECTED = "REJECTED";
	public static final String STATUS_DELETED = "DELETED";

	private Long id;
	private String username; // required
	private String password; // required
	private String confirmPassword;
	private String passwordHint;

	private String status; // required
	private Set<Role> roles = new HashSet<Role>();
	private UserDetail userDetail;
	private Integer version;

	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public User() {
	}

	/**
	 * Create a new instance and set the username.
	 * 
	 * @param username
	 *            login name for user.
	 */

	public User(final String username) {
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false, length = 50, unique = true)
	public String getUsername() {
		return username;
	}

	@Column(nullable = false)
	@XmlTransient
	public String getPassword() {
		return password;
	}

	@Transient
	@XmlTransient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Column(name = "password_hint")
	@XmlTransient
	public String getPasswordHint() {
		return passwordHint;
	}

	@OneToOne(cascade = CascadeType.ALL, targetEntity = UserDetail.class,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_detail_id", referencedColumnName = "id")
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }


	@Column(nullable = false, length = 50, unique = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}

		final User user = (User) o;

		return !(username != null ? !username.equals(user.username)
				: user.username != null);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return (username != null ? username.hashCode() : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
	      ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
          .append("username", this.username)
          .append("enabled",isEnabled())
          .append("accountExpired", !isAccountNonExpired())
          .append("credentialsExpired",!isCredentialsNonExpired())
          .append("accountLocked",!isAccountNonLocked());
	if (roles != null) {
			sb.append("Granted Authorities: ");

			int i = 0;
			for (Role role : roles) {
				if (i > 0) {
					sb.append(", ");
				}
				sb.append(role.toString());
				i++;
			}
		} else {
			sb.append("No Granted Authorities");
		}

		return sb.toString();
	}

	/**
	 * @return GrantedAuthority[] an array of roles.
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Transient
	public Set<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
		authorities.addAll(roles);
		return authorities;
	}

	@Transient
	public boolean isAccountNonExpired() {
		
		return status!= null && !status.equalsIgnoreCase(STATUS_REJECTED) && !status.equalsIgnoreCase(STATUS_DELETED);
	}

	@Transient
	public boolean isAccountNonLocked() {
		return status!= null && !status.equalsIgnoreCase(STATUS_REJECTED) && status.equalsIgnoreCase(STATUS_APPROVED);
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return status!= null && !status.equalsIgnoreCase(STATUS_REJECTED);
	}

	@Transient
	public boolean isEnabled() {
		return status!= null && status.equalsIgnoreCase(STATUS_APPROVED);
	}

	/**
	 * Adds a role for the user
	 * 
	 * @param role
	 *            the fully instantiated role
	 */
	public void addRole(Role role) {
		getRoles().add(role);
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
