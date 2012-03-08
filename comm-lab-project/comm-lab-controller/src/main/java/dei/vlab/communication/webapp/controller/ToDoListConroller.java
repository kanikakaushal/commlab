package dei.vlab.communication.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dei.vlab.communication.service.UserManager;
import dei.vlab.communication.webapp.data.ToDoData;

@Controller
public class ToDoListConroller extends BaseFormController {
	private UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value="/todolist*", method=RequestMethod.GET)
	public @ResponseBody
	List<ToDoData> getList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("entering 'Todo getlist' method...");
		}
		List<ToDoData> todoList = new ArrayList<ToDoData>();
		int pendingCount = userManager.getCountUserByPendingStatus();
		int approvedCount = userManager.getCountUserByApprovedStatus();
		int rejectedCount = userManager.getCountUserByRejectedStatus();
		int deletedCount = userManager.getCountUserByDeletedStatus();
		
		todoList.add(new ToDoData(1,"(" + pendingCount + ") User(s) approvel pending."));
		todoList.add(new ToDoData(2,"(" + approvedCount + ") Apporved User(s)."));
		todoList.add(new ToDoData(3,"(" + rejectedCount + ") Rejected User(s)."));
		todoList.add(new ToDoData(4,"(" + deletedCount + ") Deleted User(s)."));
		//System.out.println("Send data todo "+todoList);
		return todoList;
	}

}