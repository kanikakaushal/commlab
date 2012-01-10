/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author server
 *
 */
@Entity
@Table(name="circuit_privilege")
public class CircuitPrivileges extends BaseObject{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=64,nullable=false)
	private String name;
	@Column(nullable=false,length=100)
	private String description;
	/**
	 * 
	 */
	public CircuitPrivileges() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		 return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
         .append(this.name)
          .append(this.description)
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

	        final CircuitPrivileges  cirPrev = (CircuitPrivileges) o;

	        return !(name != null ? !name.equals(cirPrev.name) : cirPrev.name != null);


	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name!=null ? name.hashCode():0);
	}

}
