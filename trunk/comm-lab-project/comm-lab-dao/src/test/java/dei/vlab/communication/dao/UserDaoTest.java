package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.Rollback;

import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.model.UserDetail;

public class UserDaoTest extends BaseDaoTestCase {
	@Autowired
	private UserDao dao;
	@Autowired
	private RoleDao rolesDao;

	@Test
	@ExpectedException(DataAccessException.class)
	public void testGetUserInvalid() throws Exception {
		// should throw DataAccessException
		dao.get(100L);
	}

	@Test
	public void testGetUser() throws Exception {
		User user = dao.get(1L);
		assertNotNull(user);
	}

	@Test
	public void testGetUserPassword() throws Exception {
		User user = dao.get(1L);
		String password = dao.getUserPassword(user.getUsername());
		assertNotNull(password);
		log.debug("password: " + password);
	}

	@Test
	@Rollback(false)
	public void testSaveUser() {
		// login info
		User newUser = new User();
		newUser.setPassword("gotuam");
		newUser.setStatus("ACTIVE");
		newUser.setUsername("user1");

		// role info
		Role role = rolesDao.findRoleById(1l);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		assertNotNull(role.getId());
		newUser.setRoles(roles);

		// user detail info
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName("gotuam");
		userDetail.setLastName("last_name");
		userDetail.setEmail("gotuam@system.com");
		userDetail.setAddress1("address1");
		userDetail.setAddress2("address2");
		userDetail.setStreet("street");
		userDetail.setCity("city");
		userDetail.setCountry("country");
		newUser.setUserDetail(userDetail);
		User user = dao.saveUser(newUser);
		assertNotNull(newUser.getId());
		System.out.println("user id >>>>>>>>>>>>>>>>>>"
				+ dao.get(newUser.getId()));
		flush();

	}

	@Test
	public void testFindAllUserByRole() throws Exception {
		Role role = rolesDao.findRoleByType(Role.USER_TYPE_USER);
		List<User> users = dao.findAllUserByRole(role);
		assertNotNull(users);

	}

}
