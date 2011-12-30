package dei.vlab.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Generated;
@Entity
@Table(name="circuit_user")
public class CircuitUser extends BaseObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long circuitId;
	private User userid;
	
	
	public CircuitUser() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getCircuitId() {
		return circuitId;
	}


	public void setCircuitId(Long circuitId) {
		this.circuitId = circuitId;
	}


	public User getUserid() {
		return userid;
	}


	public void setUserid(User userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		 return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
         .append(this.userid)
         
         .toString();
	}


	@Override
	public boolean equals(Object o) {
		 if (this == o) {
	            return true;
	        }
	        if (!(o instanceof UserDetail)) {
	            return false;
	        }

	        final CircuitUser circuitUser = (CircuitUser) o;

	        return !(userid != null ? !userid.equals(circuitUser.userid) : circuitUser.userid != null);

	}


	@Override
	public int hashCode() {
		 return (userid != null ? userid.hashCode() : 0);
	}




}
