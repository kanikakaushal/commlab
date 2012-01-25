/**
 * 
 */
package dei.vlab.communication.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author server
 * 
 */
@Entity
@Table(name = "circuit_role_privilege")
public class CircuitRolePrivilege extends BaseObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Long id;
    private Circuit circuit;
    private CircuitPrivileges circuitPrivilege;
    private Set<Role> roles= new HashSet<Role>();

	/**
	 * 
	 */
    
    public CircuitRolePrivilege() {
        // TODO Auto-generated constructor stub
    }
   

    
    @ManyToOne(cascade=CascadeType.ALL,targetEntity=CircuitPrivileges.class)
    @JoinColumn(name="circuit_privilege_id",referencedColumnName="id")
    public CircuitPrivileges getCircuitPrivilege() {
		return circuitPrivilege;
	}

	public void setCircuitPrivilege(CircuitPrivileges circuitPrivilege) {
		this.circuitPrivilege = circuitPrivilege;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade=CascadeType.ALL,targetEntity=Circuit.class)
    @JoinColumn(name = "circuit_id" , referencedColumnName="id")
    public Circuit getCircuit() {
        return circuit;
    }
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")
    public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

   

    @Override
    public String toString() {
    	 return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
    	 .append(this.circuitPrivilege)
    	 .append(this.roles)
    	  .append(this.circuit)
    	   .append(this.id)
         .toString();

    }

    @Override
    public boolean equals(Object o) {
    	  if (this == o) {
              return true;
          }
          if (!(o instanceof Role)) {
              return false;
          }

          final CircuitRolePrivilege cirRolePrev = (CircuitRolePrivilege) o;

          return !(roles != null ? !roles.equals(cirRolePrev.roles) : cirRolePrev.roles != null);

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
    	 return (roles != null ? roles.hashCode() : 0);
    }

}
