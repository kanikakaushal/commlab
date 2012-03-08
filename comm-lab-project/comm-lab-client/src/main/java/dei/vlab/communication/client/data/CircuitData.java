package dei.vlab.communication.client.data;

import java.io.Serializable;

public class CircuitData implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private String type;
	private byte[] file;
	private String fileName;
	private String coordinates;

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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "CircuitData ( " + super.toString() + TAB + "id = "
				+ this.id + TAB + "name = " + this.name + TAB
				+ "description = " + this.description + TAB + "type = "
				+ this.type + TAB + "file = " + this.file + TAB + "fileName = "
				+ this.fileName + TAB + "coordinates = " + this.coordinates
				+ TAB + " )";

		return retValue;
	}

}
