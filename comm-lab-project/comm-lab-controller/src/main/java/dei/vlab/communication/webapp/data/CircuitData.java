package dei.vlab.communication.webapp.data;

import java.io.Serializable;

import javax.mail.Multipart;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dei.vlab.communication.model.Circuit;

public class CircuitData implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private String type;
	private String image;
	private String nodeData;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNodeData() {
		return nodeData;
	}
	public void setNodeData(String nodeData) {
		this.nodeData = nodeData;
	}
	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "CircuitData ( "
	        + super.toString() + TAB
	        + "id = " + this.id + TAB
	        + "name = " + this.name + TAB
	        + "description = " + this.description + TAB
	        + "type = " + this.type + TAB
	        + "image = " + this.image + TAB
	        + " )";
	
	    return retValue;
	}
	
	public static CircuitData populate(Circuit circuit){
		CircuitData circuitData = new CircuitData();
		circuitData.setId(circuit.getId().intValue());
		circuitData.setName(circuit.getName());
		circuitData.setType(circuit.getType());
		circuitData.setDescription(circuit.getDescription());
		circuitData.setImage(circuit.getImageFile());
		circuitData.setNodeData(circuit.getNoceCordinate());
		return circuitData;
	}
	

}
