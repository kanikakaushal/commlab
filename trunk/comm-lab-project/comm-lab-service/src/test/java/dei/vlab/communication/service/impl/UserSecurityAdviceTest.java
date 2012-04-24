package dei.vlab.communication.service.impl;
import dei.vlab.communication.Constants;
import dei.vlab.communication.dao.UserDao;
import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.service.UserManager;
import dei.vlab.communication.service.UserSecurityAdvice;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import static org.junit.Assert.*;

@RunWith(JMock.class)
public class UserSecurityAdviceTest {
    Mockery context = new JUnit4Mockery();
    UserDao userDao = null;
    ApplicationContext ctx = null;
    SecurityContext initialSecurityContext = null;

    @Before
    public void setUp() throws Exception {
        // store initial security context for later restoration
        initialSecurityContext = SecurityContextHolder.getContext();

        SecurityContext context = new SecurityContextImpl();
        User user = new User("user");
        user.setStatus(User.STATUS_APPROVED);
        user.setId(1L);
        user.setPassword("password");
        Role role = getUserRole();
        user.addRole(role);
        System.out.println("user.getAuthorities()"+user.getAuthorities());

        UsernamePasswordAuthenticationToken token =
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        token.setDetails(user);
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);
    }

	private Role getUserRole() {
	Role role =new Role(Role.ROLE_BEGINNER);
        role.setType(Role.USER_TYPE_USER);
	return role;
	}

    @After
    public void tearDown() {
        SecurityContextHolder.setContext(initialSecurityContext);
    }

    @Test
    public void testAddUserWithoutAdminRole() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assertTrue(auth.isAuthenticated());
        UserManager userManager = makeInterceptedTarget();
        User user = new User("admin");
        user.setStatus(User.STATUS_APPROVED);
        user.setId(2L);

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            Assert.assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    @Test
    public void testAddUserAsAdmin() throws Exception {
        SecurityContext securityContext = new SecurityContextImpl();
        User user = new User("admin");
        user.setId(2L);
        user.setStatus(User.STATUS_APPROVED);
        user.setPassword("password");
        user.addRole(getAdminRole());
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        token.setDetails(user);
        System.out.println("user -->"+user);
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);

        UserManager userManager = makeInterceptedTarget();
        final User adminUser = new User("admin");
        adminUser.setStatus(User.STATUS_APPROVED);
        adminUser.addRole(getAdminRole());
        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(adminUser)));
        }});

        userManager.saveUser(adminUser);
    }
	private Role getAdminRole() {
		Role role= new Role(Role.ROLE_ADMIN);
		role.setType(Role.USER_TYPE_ADMIN);
		return role;
	}

   @Test
    public void testUpdateUserProfile() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        final User user = new User("user");
        user.setStatus(User.STATUS_APPROVED);
       // user.setId(1L);
        user.getRoles().add(getUserRole());
        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user)));
        }});

        userManager.saveUser(user);
    }
    
    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testChangeToAdminRoleFromUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user");
        user.setStatus(User.STATUS_APPROVED);
        user.setId(1L);
        user.getRoles().add(getAdminRole());

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testAddAdminRoleWhenAlreadyHasUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user");
        user.setStatus(User.STATUS_APPROVED);
        user.setId(1L);
        user.getRoles().add(getAdminRole());
        user.getRoles().add(getUserRole());

        try {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown");
        } catch (AccessDeniedException expected) {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
    @Test
    public void testAddUserRoleWhenHasAdminRole() throws Exception {
        SecurityContext securityContext = new SecurityContextImpl();
        User user1 = new User("user");
        user1.setStatus(User.STATUS_APPROVED);
        user1.setId(1L);
        user1.setPassword("password");
        user1.addRole(getAdminRole());
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user1.getUsername(), user1.getPassword(), user1.getAuthorities());
        token.setDetails(user1);
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);

        UserManager userManager = makeInterceptedTarget();
        final User user = new User("user");
        user.setStatus(User.STATUS_APPROVED);
        user.getRoles().add(getUserRole());
        user.getRoles().add(getAdminRole());

        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user)));
        }});

        userManager.saveUser(user);
    }

    // Test fix to http://issues.appfuse.org/browse/APF-96
   @Test
    public void testUpdateUserWithUserRole() throws Exception {
        UserManager userManager = makeInterceptedTarget();
        final User user = new User("user");
        //user.setId(1L);
        user.getRoles().add(getUserRole());

        context.checking(new Expectations() {{
            one(userDao).saveUser(with(same(user)));
        }});

        userManager.saveUser(user);
    }

    private UserManager makeInterceptedTarget() {
        ctx = new ClassPathXmlApplicationContext("/applicationContext-test.xml");

        UserManager userManager = (UserManager) ctx.getBean("target");

        // Mock the userDao
        userDao = context.mock(UserDao.class);
        userManager.setUserDao(userDao);
        return userManager;
    }
}
