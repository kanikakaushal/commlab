package dei.vlab.communication.dao.hibernate;

import java.util.List;

import dei.vlab.communication.dao.UserDao;
import dei.vlab.communication.dao.UserDetailDao;
import dei.vlab.communication.model.UserDetail;

public class UserDetailDaoHibernate extends GenericDaoHibernate<UserDetail, Long> implements UserDetailDao{

	public UserDetailDaoHibernate() {
		super(UserDetail.class);
	}

	public List<UserDetail> getUserDetail(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	



	


}
