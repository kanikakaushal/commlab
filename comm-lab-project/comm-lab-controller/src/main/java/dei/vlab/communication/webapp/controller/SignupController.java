package dei.vlab.communication.webapp.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dei.vlab.communication.Constants;
import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.model.UserDetail;
import dei.vlab.communication.service.RoleManager;
import dei.vlab.communication.service.UserExistsException;
import dei.vlab.communication.webapp.util.RequestUtil;

@Controller
public class SignupController extends BaseFormController {
	private RoleManager roleManager;

	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	
	@RequestMapping("/signup*")
	public @ResponseBody
	Map<String, String> onSubmit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("entering 'onSubmit' method...");
		}

		User user = populateUserDatailInfo(request);
		Locale locale = request.getLocale();

		user.setStatus(User.STATUS_PENDING);

		// Set the default user role on this new user
		user.addRole(roleManager.getRole(Role.ROLE_BEGINNER));
		Map<String, String> map = new HashMap<String, String>();

		try {
			this.getUserManager().saveUser(user);
		} catch (AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			log.warn(ade.getMessage());
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			map.clear();
			map.put("error", ade.getMessage());
			return map;
		} catch (UserExistsException e) {

			map.clear();
			map.put("error", e.getMessage());
			// redisplay the unencrypted passwords
			user.setPassword(user.getConfirmPassword());

		}

		saveMessage(request,
				getText("user.registered", user.getUsername(), locale));
		request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

		/*// log user in automatically
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getConfirmPassword(),
				user.getAuthorities());
		auth.setDetails(user);
		SecurityContextHolder.getContext().setAuthentication(auth);*/

		// Send user an e-mail
		if (log.isDebugEnabled()) {
			log.debug("Sending user '" + user.getUsername()
					+ "' an account information e-mail");
		}

		// Send an account information e-mail
		message.setSubject(getText("signup.email.subject", locale));

		try {
			sendUserMessage(user, getText("signup.email.message", locale),
					RequestUtil.getAppURL(request));
		} catch (MailException me) {
			saveError(request, me.getMostSpecificCause().getMessage());
		}

		map.put("success",
				"You have successfully registered. Your registration has sent to administrator for approvel. "
						+ "<br/> You will receive mail of approvel from admintrator for login");
		
		System.out.println("return's "+map);
		return map;

	}

	private User populateUserDatailInfo(HttpServletRequest request) {
		User user = new User();
		UserDetail detail = new UserDetail();
		String firstName = (String) request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String college = request.getParameter("college");
		String street = request.getParameter("street");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String contactNo = request.getParameter("contactNo");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");

		detail.setFirstName(firstName);
		detail.setLastName(lastName);
		detail.setCollegeName(college);
		detail.setAddress1(address1);
		detail.setAddress2(address2);
		detail.setEmail(email);
		detail.setStreet(street);
		detail.setCity(city);
		detail.setCountry(country);
		detail.setContactNo(contactNo);

		user.setUsername(email);
		user.setPassword(password);
		user.setUserDetail(detail);
		return user;

	}

}
