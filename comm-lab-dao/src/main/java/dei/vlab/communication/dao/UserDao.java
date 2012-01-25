package dei.vlab.communication.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dei.vlab.communication.model.User;

/**
 * User Data Access Object (GenericDao) interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */

public interface UserDao extends GenericDao<User, Long> {

    /**
     * Gets a list of users ordered by the uppercase version of their username.
     * 
     * @return List populated list of users
     */
    List<User> getUsers();
    

    /**
     * Saves a user's information.
     * 
     * @param user
     *            the object to be saved
     * @return the persisted User object
     */
    User saveUser(User user);

    /**
     * Retrieves the password in DB for a user
     * 
     * @param username
     *            the user's username
     * @return the password in DB, if the user is already persisted
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(String username);

}
