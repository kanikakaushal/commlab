/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "experiment")
public class Experiment extends BaseObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String type;

    private String noceCordinate;

    private String imageFile;

    private String configProperties;
    private String remark;

    private Circuit circuits;
    private User users;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Circuit.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "circuit_id", referencedColumnName = "id")
    public Circuit getCircuits() {
        return circuits;
    }

    public void setCircuits(Circuit circuits) {
        this.circuits = circuits;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    /**
	 * 
	 */
    public Experiment() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "node_coordinates", nullable = false)
    public String getNoceCordinate() {
        return noceCordinate;
    }

    public void setNoceCordinate(String noceCordinate) {
        this.noceCordinate = noceCordinate;
    }

    @Column(nullable = false)
    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    @Column(nullable = false)
    public String getConfigProperties() {
        return configProperties;
    }

    public void setConfigProperties(String configProperties) {
        this.configProperties = configProperties;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.name).append(this.type)
                .append(this.id).toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Experiment experiment = (Experiment) o;

        return !(name != null ? !name.equals(experiment.name) : experiment.name != null);

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return (name != null ? name.hashCode() : 0);
    }

}
