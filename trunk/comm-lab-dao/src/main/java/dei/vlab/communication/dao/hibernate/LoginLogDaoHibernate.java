package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.LoginLogDao;
import dei.vlab.communication.model.LoginLog;
@Repository("LoginLog")
public class LoginLogDaoHibernate extends GenericDaoHibernate<LoginLog, Long> implements LoginLogDao {

	public LoginLogDaoHibernate() {
		// TODO Auto-generated constructor stub
		super(LoginLog.class);
	}

	public LoginLog get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public LoginLog save(LoginLog object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<LoginLog> getLog(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
