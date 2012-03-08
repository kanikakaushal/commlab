package dei.vlab.communication.webapp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionContextIntegrationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.model.UserDetail;
import dei.vlab.communication.webapp.data.UserData;

@Controller
public class AuthController {
	public static final String SECURITY_CONTEXT = HttpSessionContextIntegrationFilter.SPRING_SECURITY_CONTEXT_KEY;

	private transient final Log log = LogFactory.getLog(AuthController.class);

	@RequestMapping("/logout*")
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		User user = getSecuityContextUsername(session);
		log.info("User [" + user.getUsername() + "] has signout");
		session.invalidate();

		return new ModelAndView("redirect:/login.html");

	}

	@RequestMapping("/userinfo*")
	public @ResponseBody
	Map<String, String> getLoggedInUserInfo(HttpServletRequest request) {
		Map<String, String> userInfoMap = new HashMap<String, String>();
		User user = getSecuityContextUsername(request.getSession());

		if (null != user) {
			String roleName = null;
			Set<Role> roles = user.getRoles();
			for (Role role : roles) {
				roleName = role.getName();
				break;
			}
			UserDetail userDetail = user.getUserDetail();
			userInfoMap.put("fullName", userDetail.getFullName());
			userInfoMap.put("roleName", roleName);
		}

		return userInfoMap;

	}

	@RequestMapping("/loginfailure*")
	public @ResponseBody
	Map<String, String> loginFailure(HttpServletRequest request) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("error", "Login Failed");

		System.out.println("loginfailure  " + info);
		return info;

	}

	@RequestMapping("/accountinfo*")
	public @ResponseBody
	UserData accoutInfo(HttpServletRequest request) {
		User user = getSecuityContextUsername(request.getSession());

		return populateUserData(user);
	}

	private UserData populateUserData(User user) {
		UserData data = new UserData();
		UserDetail detail = user.getUserDetail();
		data.setStatus(user.getStatus());
		data.setEmail(detail.getEmail());
		data.setSno(0);
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

	/*
	 * @RequestMapping("/authenticate*") public @ResponseBody Map<String,
	 * String> authenticate(HttpServletRequest request) { Map<String, String>
	 * info = new HashMap<String, String>(); info.put("success",
	 * "Login passed"); System.out.println("authenticate  "+info); return info;
	 * 
	 * }
	 */
	private User getSecuityContextUsername(HttpSession session) {
		final SecurityContext securityContext = (SecurityContext) session
				.getAttribute(SECURITY_CONTEXT);
		if (securityContext.getAuthentication() != null
				&& securityContext.getAuthentication().getPrincipal() instanceof User) {
			final User user = (User) securityContext.getAuthentication()
					.getPrincipal();
			return user;
		}
		return null;
	}

}
