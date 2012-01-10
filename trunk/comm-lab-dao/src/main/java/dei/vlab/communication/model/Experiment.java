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
@Table(name="experiment")
public class Experiment extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length=64,nullable=false)
	private String name;
	@Column(length=100,nullable=false)
	private String type;
	@Column(nullable=false)
	private String node_coordinate;
	@Column(nullable=false)
	private String image_file;
	private String config_properties;
	
	/**
	 * 
	 */
	
	public Experiment() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNode_coordinate() {
		return node_coordinate;
	}

	public void setNode_coordinate(String node_coordinate) {
		this.node_coordinate = node_coordinate;
	}

	public String getInmage_file() {
		return image_file;
	}

	public void setInmage_file(String inmage_file) {
		this.image_file = inmage_file;
	}

	public String getConfig_properties() {
		return config_properties;
	}

	public void setConfig_properties(String config_properties) {
		this.config_properties = config_properties;
	}

	@Override
	public String toString() {
		 return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
         .append(this.name)
         .append(this.type)
         .append(this.config_properties)
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

	        final Experiment exp = (Experiment) o;

	        return !(name != null ? !name.equals(exp.name) : exp.name != null);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name != null ? name.hashCode():0);
	}

}
