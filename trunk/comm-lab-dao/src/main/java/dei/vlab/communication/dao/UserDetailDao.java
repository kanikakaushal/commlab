package dei.vlab.communication.dao;

import java.util.List;


import dei.vlab.communication.model.UserDetail;

public interface UserDetailDao extends GenericDao<UserDetail, Long>  {
	
	List<UserDetail> getUserDetail(Long userId);

}
