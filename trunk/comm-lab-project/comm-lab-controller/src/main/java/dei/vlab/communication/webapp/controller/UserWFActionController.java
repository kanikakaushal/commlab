package dei.vlab.communication.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dei.vlab.communication.model.User;
import dei.vlab.communication.model.UserDetail;
import dei.vlab.communication.service.UserManager;
import dei.vlab.communication.service.impl.UserManagerImpl;
import dei.vlab.communication.webapp.data.UserData;

@Controller
public class UserWFActionController {

	private UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value = "/userwfaction", method = RequestMethod.GET)
	public @ResponseBody
	List<UserData> getAllUsers() {
		List<UserData> userDatas = new ArrayList<UserData>();
		List<User> users = userManager.getAllUsersHavingRoleUser();
		System.out.println("user list ->>>>>>"+users);
		int sno = 1;
		if (users != null && !users.isEmpty()) {
			for (User user : users) {
				userDatas.add(populateUserData(user, sno));
				sno++;
			}
		}
		System.out.println("final user list ->>>>>>"+userDatas);

		return userDatas;
	}

	@RequestMapping(value = "/userwfactionupdate", method = RequestMethod.GET)
	public @ResponseBody
	String updateUserStatus(HttpServletRequest request) {
		String idStr =request.getParameter("id");
		String status =request.getParameter("status")!=null?request.getParameter("status"):"";
			
		System.out.println("Updating user "+idStr+" status "+status);
		if(null!=idStr && idStr.length()>0){
		Long id =Long.parseLong(idStr);
		System.out.println("Updating user "+id+" status "+status);
		if(status.equalsIgnoreCase(User.STATUS_APPROVED)){
			userManager.updateUserStatus(id,User.STATUS_APPROVED);
		}
		else if(status.equalsIgnoreCase(User.STATUS_REJECTED)){
			userManager.updateUserStatus(id,User.STATUS_REJECTED);
		}
		else if(status.equalsIgnoreCase(User.STATUS_DELETED)){
			userManager.updateUserStatus(id,User.STATUS_DELETED);
		}
		else {
			return "error";
		}
		}else{
			return "error";
		}

		return "success";
	}

	private UserData populateUserData(User user, int sno) {
		UserData data = new UserData();
		UserDetail detail = user.getUserDetail();
		data.setStatus(user.getStatus());
		data.setEmail(detail.getEmail());
		data.setSno(sno);
		data.setFullName(detail.getFullName());
		data.setFirstName(detail.getFirstName());
		data.setLastName(detail.getLastName());
		data.setAddress1(detail.getAddress1());
		data.setAddress2(detail.getAddress2());
		data.setStreet(detail.getStreet());
		data.setCity(detail.getCity());
		data.setCountry(detail.getCountry());
		data.setCollege(detail.getCollegeName());
		data.setContactNo(detail.getContactNo());
		data.setId(user.getId().intValue());
		return data;
	}
}
