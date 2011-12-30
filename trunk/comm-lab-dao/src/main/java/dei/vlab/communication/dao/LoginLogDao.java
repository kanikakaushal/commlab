/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.LoginLog;

/**
 * @author server
 *
 */
public interface LoginLogDao extends GenericDao<LoginLog, Long>{
	
	List<LoginLog> getLog(Long userId);
	
}
