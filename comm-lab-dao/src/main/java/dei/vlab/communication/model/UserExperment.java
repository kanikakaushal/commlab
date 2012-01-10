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
@Table(name="user_experment")
public class UserExperment extends BaseObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="circuit_id")
	private Circuit circuit;
	@ManyToOne
	@JoinColumn(name="experiment_id")
	private Experiment experiment;
	
	
	/**
	 * 
	 */
	public UserExperment() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Experiment getExperiment() {
		return experiment;
	}


	public void setExperiment(Experiment experiment) {
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
