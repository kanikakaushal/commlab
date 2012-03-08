package dei.vlab.communication.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dei.vlab.communication.model.User;
import dei.vlab.communication.service.UserManager;



@Controller
public class UserController {
    private UserManager mgr = null;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.mgr = userManager;
    }

    @RequestMapping("/admin/listuser*")
	public @ResponseBody List<User> listUsers(){
    	List<User> userList = mgr.getAll();
    	return userList;
    }
}
