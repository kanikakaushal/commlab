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
public class UserDetailDaoHibernate extends GenericDaoHibernate<UserDetail, Long> implements UserDetailDao {

    /**
	 * 
	 */
    public UserDetailDaoHibernate() {
        super(UserDetail.class);
    }

    public UserDetail findeUserById(Long id) {

        List user = getHibernateTemplate().find("from UserDetail where id=?", id);
        if (user.isEmpty()) {
            return null;
        }
        return (UserDetail) user.get(0);

    }

    public UserDetail findeUserByName(String name) {
        List user = getHibernateTemplate().find("from UserDetail where first_name=?", name);
        if (user.isEmpty()) {
            return null;
        }
        return (UserDetail) user.get(0);
    }

    public List findAllUserDetail() {
        List userDetailList = null;
        userDetailList = getHibernateTemplate().find("from UserDetail");
        if (userDetailList.isEmpty()) {
            return null;
        }
        return userDetailList;
    }

    public void deleteUserDetailById(Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Delete user's detail id: " + id);
        }
        Object delObject = getHibernateTemplate().load(UserDetail.class, id);
        if (delObject != null) {
            getHibernateTemplate().delete(delObject);
        }
    }

    public UserDetail saveUserDetail(UserDetail userDetail) {
        if (log.isDebugEnabled()) {
            log.debug("save detail id: " + userDetail);
        }
        getHibernateTemplate().saveOrUpdate(userDetail);
        return userDetail;
    }

}
