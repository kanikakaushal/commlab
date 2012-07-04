package dei.vlab.communication.client.widgets.link;

import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.text.shared.Parser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CNodeData {

	private int id;
	private String name;
	private String description;
	private int left;
	private int top;
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = ";";

		String retValue = "";

		retValue = "CNodeData ( " + "id = " + this.id + TAB + "name = "
				+ this.name + TAB + "description = " + this.description + TAB
				+ "left = " + this.left + TAB + "top = " + this.top + TAB
				+ " )";

		return retValue;
	}

	public static CNodeData create(String data) {
		
		CNodeData cnode = new CNodeData();
		try{

		if (data != null && !data.isEmpty()) {
			ListGridRecord parser = new ListGridRecord();
			data = data.replace("(", "");
			data = data.replace(")", "");
			for (String fl : data.split(";")) {
				data=data.replace(";", "");
				String[] keyValue = fl.split("=");
				
				if (keyValue.length == 2) {
					String key=keyValue[0].trim();
					String value=keyValue[1].trim();
					if ("id".equalsIgnoreCase(key)) {
						parser.setAttribute("id", value);
						cnode.setId(parser.getAttributeAsInt("id"));
					}
					if ("name".equalsIgnoreCase(key)) {
						cnode.setName(value);
					}
					if ("description".equalsIgnoreCase(key)) {
						cnode.setDescription(value);
					}
					if ("left".equalsIgnoreCase(key)) {
						SC.say("value of left " +value);
						parser.setAttribute("left", value);
						cnode.setLeft(parser.getAttributeAsInt("left"));
					}
					if ("top".equalsIgnoreCase(key)) {
						parser.setAttribute("top", value);
						cnode.setTop(parser.getAttributeAsInt("top"));
					}
				}
			}

		}
		}catch (Exception e) {
			SC.say("excetion in const "+e.getLocalizedMessage());
		}

		return cnode;

	}
}
