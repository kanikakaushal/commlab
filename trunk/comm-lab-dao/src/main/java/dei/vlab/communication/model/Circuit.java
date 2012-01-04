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
@Table(name="circuit")
public class Circuit extends BaseObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="circuit_id")
	private Long circuitId;
	@Column(name="name",nullable=false,unique=true,length=200)
	private String circuitName;
	@Column(name="type",nullable=false,length=100)
	private String circuitType;
	@Column(name="node_coordinates")
	@Lob
	private String circuitNodeCoordinate;
	@Column(name="image_file",nullable=false)
	private String circuitImageFile;
	@Column(name="config_properties",nullable=false)
	private String circuitConfigProperties;
	@Column(name="remark")
	private String circuitRemark;
	/**
	 * 
	 */
	public Circuit() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getCircuitId() {
		return circuitId;
	}
	public void setCircuitId(Long circuitId) {
		this.circuitId = circuitId;
	}
	public String getCircuitName() {
		return circuitName;
	}
	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}
	public String getCircuitType() {
		return circuitType;
	}
	public void setCircuitType(String circuitType) {
		this.circuitType = circuitType;
	}
	public String getCircuitNodeCoordinate() {
		return circuitNodeCoordinate;
	}
	public void setCircuitNodeCoordinate(String circuitNodeCoordinate) {
		this.circuitNodeCoordinate = circuitNodeCoordinate;
	}
	public String getCircuitImageFile() {
		return circuitImageFile;
	}
	public void setCircuitImageFile(String circuitImageFile) {
		this.circuitImageFile = circuitImageFile;
	}
	public String getCircuitConfigProperties() {
		return circuitConfigProperties;
	}
	public void setCircuitConfigProperties(String circuitConfigProperties) {
		this.circuitConfigProperties = circuitConfigProperties;
	}
	public String getCircuitRemark() {
		return circuitRemark;
	}
	public void setCircuitRemark(String circuitRemark) {
		this.circuitRemark = circuitRemark;
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
