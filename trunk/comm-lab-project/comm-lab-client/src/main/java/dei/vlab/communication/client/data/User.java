package dei.vlab.communication.client.data;

import java.util.Map;

import com.google.gwt.user.client.Window;

import dei.vlab.communication.client.util.JsonConverter;

public class User {
	public User() {
	}

	public User(String userName, String status, String roleName) {
		super();
		this.userName = userName;
		this.status = status;
		this.roleName = roleName;
	}
	
	public User(String userInfoJSON){
		Map<String,Object> userMap= JsonConverter.decode(userInfoJSON);
		this.userName=(String)userMap.get("fullName");
		this.roleName=(String)userMap.get("roleName");
		this.status="Active";
	}
	

	private String userName;
	private String status;
	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isAdmin() {
		if ("ROLE_ADMIN".equalsIgnoreCase(this.roleName))
			return true;
		return false;
	}


}
