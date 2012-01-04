/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author server
 *
 */
@Entity
@Table(name="user_experment")
public class UserExperment extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private Long userExpermentId;
	@MapsId("userExpermentUserIdPk")
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@MapsId("userExpermentCircuitIdPk")
	@ManyToOne
	@JoinColumn(name="circuit_id")
	private Circuit circuit;
	
	@MapsId("userExpermentExpermentIdPk")
	@ManyToOne
	@JoinColumn(name="experiment_id")
	private Experiments experiment;
	
	
	/**
	 * 
	 */
	public UserExperment() {
		// TODO Auto-generated constructor stub
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Circuit getCircuit() {
		return circuit;
	}


	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}


	public Experiments getExperiment() {
		return experiment;
	}


	public void setExperiment(Experiments experiment) {
		this.experiment = experiment;
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
