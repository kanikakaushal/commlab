/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author server
 *
 */
@Entity
@Table(name="experiment")
public class Experiments extends BaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	private Long UserExperimentId;
	@Column(name="name",nullable=false,length=200,unique=true)
	private String experimentName;
	@Column(name="type",nullable=false,length=100)
	private String experimentType;
	@Column(name="node_coordinate",nullable=false)
	@Lob
	private String nodeCoordinate;
	@Column(name="image_file",nullable=false)
	private String imageFile;
	@Column(name="config_properties")
	private String configProperties;
	
	/**
	 * 
	 */
	public Experiments() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserExperimentId() {
		return UserExperimentId;
	}

	public void setUserExperimentId(Long userExperimentId) {
		UserExperimentId = userExperimentId;
	}

	public String getExperimentName() {
		return experimentName;
	}

	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}

	public String getExperimentType() {
		return experimentType;
	}

	public void setExperimentType(String experimentType) {
		this.experimentType = experimentType;
	}

	public String getNodeCoordinate() {
		return nodeCoordinate;
	}

	public void setNodeCoordinate(String nodeCoordinate) {
		this.nodeCoordinate = nodeCoordinate;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(String configProperties) {
		this.configProperties = configProperties;
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
