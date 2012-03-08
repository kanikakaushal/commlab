package dei.vlab.communication.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dei.vlab.communication.dao.RoleDao;
import dei.vlab.communication.dao.UserDao;
import dei.vlab.communication.model.Role;
import dei.vlab.communication.model.User;
import dei.vlab.communication.service.UserExistsException;
import dei.vlab.communication.service.UserManager;


@Service("userManager")
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager{
    private PasswordEncoder passwordEncoder;
    private UserDao userDao;
    private RoleDao roleDao; 

     @Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.dao = userDao;
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     */
    public User getUser(String userId) {
        return userDao.get(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return userDao.getAllDistinct();
    }

    /**
     * {@inheritDoc}
     */
    public User saveUser(User user) throws UserExistsException {
    	log.info("is user in new in system "+user.getId());
        if (user.getVersion() == null) {
            System.out.println("username "+user.getUsername());
            user.setUsername(user.getUsername().toLowerCase());
        }

        // Get and prepare password management-related artifacts
        boolean passwordChanged = false;
        if (passwordEncoder != null) {
            // Check whether we have to encrypt (or re-encrypt) the password
            if (user.getVersion() == null) {
                // New user, always encrypt
                passwordChanged = true;
            } else {
                // Existing user, check password in DB
                String currentPassword = userDao.getUserPassword(user.getUsername());
                if (currentPassword == null) {
                    passwordChanged = true;
                } else {
                    if (!currentPassword.equals(user.getPassword())) {
                        passwordChanged = true;
                    }
                }
            }

            // If password was changed (or new user), encrypt it
            if (passwordChanged) {
                user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
            }
        } else {
            log.warn("PasswordEncoder not set, skipping password encryption...");
        }

        try {
            return userDao.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            //e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        } catch (JpaSystemException e) { // needed for JPA
            //e.printStackTrace();
            log.warn(e.getMessage());
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(String userId) {
        log.debug("removing user: " + userId);
        userDao.remove(new Long(userId));
    }

    /**
     * {@inheritDoc}
     *
     * @param username the login name of the human
     * @return User the populated user object
     * @throws UsernameNotFoundException thrown when username not found
     */
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return (User) userDao.loadUserByUsername(username);
    }

    /**
     * {@inheritDoc}
     */
    public List<User> search(String searchTerm) {
        return super.search(searchTerm, User.class);
    }

	public int getCountUserByPendingStatus() {
		// TODO Auto-generated method stub
		return userDao.findUserCountByStatus(User.STATUS_PENDING);
	}

	public int getCountUserByApprovedStatus() {
		// TODO Auto-generated method stub
		return userDao.findUserCountByStatus(User.STATUS_APPROVED);
	}

	public int getCountUserByRejectedStatus() {
		// TODO Auto-generated method stub
		return userDao.findUserCountByStatus(User.STATUS_REJECTED);
	}

	public int getCountUserByDeletedStatus() {
		// TODO Auto-generated method stub
		return userDao.findUserCountByStatus(User.STATUS_DELETED);
	}

	public List<User> getAllUsersHavingRoleUser() {
		Role role =roleDao.findRoleByType(Role.USER_TYPE_USER);
		System.out.println("role "+role);
		return userDao.findAllUserByRole(role);
	}
	
	public void updateUserStatus(Long userId,String status) {
		System.out.println("Updating user "+userId+" status "+status);
		userDao.updateUserStatus(userId,status);
		System.out.println("updated user "+userId+" status "+status);
	}

	
}
