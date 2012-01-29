/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author server
 * 
 */
@Entity
@Table(name = "user_experment")

public class UserExperment extends BaseObject {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private Long id;
    private User users;
    private Circuit circuits;
	private Experiment experiment;

    /**
	 * 
	 */
    public UserExperment() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

  

    @ManyToOne(targetEntity=Experiment.class ,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "experiment_id" ,referencedColumnName="id")
    public Experiment getExperiment() {
        return experiment;
    }

    @ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName="id")
    public User getUsers() {
		return users;
	}

    @ManyToOne(targetEntity=Circuit.class,cascade=CascadeType.ALL)
    @JoinColumn(name="circuit_id",referencedColumnName="id")
    public Circuit getCircuits() {
		return circuits;
	}

	public void setCircuits(Circuit circuits) {
		this.circuits = circuits;
	}

	public void setUsers(User users) {
		this.users = users;
	}

    public void setId(Long id) {
        this.id = id;
    }

 
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    @Override
    public String toString() {
    	return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
    	.append(this.users)
    	.append(this.circuits)
        .append(this.experiment)
        .toString();
    }

    @Override
    public boolean equals(Object o) {
    	 if (this == o) {
             return true;
         }
         if (!(o instanceof User)) {
             return false;
         }

         final UserExperment userExp = (UserExperment) o;

         return !(users != null ? !users.equals(userExp.users) : userExp.users != null);
    }

    @Override
    public int hashCode() {
    	return (users != null ? users.hashCode() : 0);
    }

}
