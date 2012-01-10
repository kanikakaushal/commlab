/**
 * 
 */
package dei.vlab.communication.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dei.vlab.communication.model.Message;

/**
 * @author server
 *
 */
public class MessageDaoTest extends BaseDaoTestCase {
	@Autowired
	private MessageDao messageDao;
	
	@Test
	public void getTestMessage() throws Exception{
		Message message= messageDao.getMessagesById(1L);
	}

}
