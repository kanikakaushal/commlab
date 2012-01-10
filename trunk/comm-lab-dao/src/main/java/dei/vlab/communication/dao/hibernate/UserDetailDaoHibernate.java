/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.UserDetailDao;
import dei.vlab.communication.model.UserDetail;

/**
 * @author server
 *
 */
@Repository
public class UserDetailDaoHibernate  extends GenericDaoHibernate<UserDetail, Long> implements UserDetailDao{

	/**
	 * 
	 */
	public UserDetailDaoHibernate() {
		super(UserDetail.class);
	}

	public UserDetail getUserDetailById(Long userId) {
	UserDetail userDetail=null;
	try {
		System.out.println("hii i am in the user detail dao hibernate");
		userDetail= getHibernateTemplate().load(UserDetail.class, userId);
		if(userDetail==null){
			return null;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		return userDetail;
	}

	public UserDetail getUserDetailbyname(String userName) {
		UserDetail userDetailByName=null;
		try {
			userDetailByName= getHibernateTemplate().load(UserDetail.class,userName);
			if(userDetailByName==null){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			return userDetailByName;
		}

	public UserDetail saveUserDetail(UserDetail userId) {
		 if (log.isDebugEnabled()) {
	         log.debug("save user's id: " + userId);
	        }
		try {
			getHibernateTemplate().saveOrUpdate(userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userId;
	}

	public List getUserDetai() {
		List useList=null;
		try {
			useList= getHibernateTemplate().find("from UserDetail");
			if(useList.isEmpty()){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return useList;
	}

	public void deleteUserDetail(Long userId) {
		try {
			Object delObject =getHibernateTemplate().load(UserDetail.class, userId);
			if(delObject!=null){
				getHibernateTemplate().delete(delObject);
				getHibernateTemplate().flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
