package dei.vlab.communication.client.data;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class UserRecord extends ListGridRecord {

	public UserRecord() {
	}

	public UserRecord(String no, String status, String userId, String fullName) {
		setNo(no);
		setStatus(status);
		setUserId(userId);
		setFullName(fullName);
	}

	public void setFullName(String fullName) {
		setAttribute("fullName", fullName);
	}

	public String getFullName() {
		return getAttributeAsString("fullName");
	}

	public void setStatus(String status) {
		setAttribute("status", status);
	}

	public String getStatus() {
		return getAttributeAsString("status");
	}

	public void setNo(String no) {
		setAttribute("no", no);
	}

	public String getNo() {
		return getAttributeAsString("no");
	}

	public void setUserId(String userID) {
		setAttribute("userID", userID);
	}

	public String getUserId() {
		return getAttributeAsString("userID");
	}

}