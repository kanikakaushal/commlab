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
	 * Get User Detail by user id from the user_detail table
	 */

	UserDetail getUserDetailById(Long userId);
	
	/*
	 * Get UserDetail by user name 
	 */
	UserDetail getUserDetailbyname(String userName);
	/*
	 * save user Detail by id
	 */
	UserDetail saveUserDetail(UserDetail userId);
	
	/*
	 * Get All detail.
	 */
	List getUserDetai();
	/*
	 * delete user detail
	 */
	void deleteUserDetail(Long userId);
}
