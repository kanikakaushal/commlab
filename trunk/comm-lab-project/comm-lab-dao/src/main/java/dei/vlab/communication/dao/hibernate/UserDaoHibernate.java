package dei.vlab.communication.dao.hibernate;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Query;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.UserDao;
import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;

@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements
		UserDao, UserDetailsService {

	/**
	 * Constructor that sets the entity to User.class.
	 */
	public UserDaoHibernate() {
		super(User.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getHibernateTemplate().find(
				"from User u order by upper(u.username)");
	}

	/**
	 * {@inheritDoc}
	 */
	public User saveUser(User user) {
		if (log.isDebugEnabled()) {
			log.debug("user's id: " + user.getId());
		}
		getHibernateTemplate().saveOrUpdate(user);
		// necessary to throw a DataIntegrityViolation and catch it in
		// UserManager
		getHibernateTemplate().flush();
		return user;
	}

	/**
	 * Overridden simply to call the saveUser method. This is happenening
	 * because saveUser flushes the session and saveObject of BaseDaoHibernate
	 * does not.
	 * 
	 * @param user
	 *            the user to save
	 * @return the modified user (with a primary key set if they're new)
	 */
	@Override
	public User save(User user) {
		return this.saveUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUserPassword(String username) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(
				SessionFactoryUtils.getDataSource(getSessionFactory()));
		Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
		return jdbcTemplate.queryForObject(
				"select password from " + table.name() + " where username=?",
				String.class, username);

	}

	/**
	 * {@inheritDoc}
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("Autentication process for user " + username);
		log.info("Autentication process for user " + username);
		List users = getHibernateTemplate().find("from User where username=?",
				username);
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username
					+ "' not found...");
		} else {
			System.out.println("Autentication process for user found "
					+ users.get(0));
			log.info("Autentication process for user found " + users.get(0));
			return (UserDetails) users.get(0);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int findUserCountByStatus(String status) {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(
				SessionFactoryUtils.getDataSource(getSessionFactory()));
		Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
		return jdbcTemplate.queryForObject(
				"select count(*) from " + table.name() +  " u ,user_role ur ,role r WHERE u.status=?" +
						" AND u.id=ur.user_id AND r.id=ur.roles_id AND r.type='USER';",
				Integer.class, status);
		
	}

	public List<User> findAllUserByRole(Role role) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from User where :role in elements(roles)");
		query.setEntity("role", role);
		List<User> users = (List<User>) query.list();
		return users;
	}

	public void updateUserStatus(Long userId, String status) {
		User user = get(userId);
		user.setStatus(status);
		saveUser(user);
		
	}

}
