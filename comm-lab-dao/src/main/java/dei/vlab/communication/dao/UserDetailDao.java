/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.UserDetail;

/**
 * @author server
 * 
 */
public interface UserDetailDao extends GenericDao<UserDetail, Long> {
    /*
     * Find User Detail by user id from the user_detail table
     */

    UserDetail findeUserDetailById(Long id);

    /*
     * Find UserDetail by user first name
     */
    UserDetail findeUserDetailByFirstName(String name);

    /*
     * Save user Detail by id
     */
    UserDetail saveUserDetail(UserDetail userDetail);

    /*
     * Find All detail.
     */
    List findAllUserDetail();

    /*
     * Delete user detail by user Detail id
     */
    void deleteUserDetailById(Long id);
}
