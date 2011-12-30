package dei.vlab.communication.dao;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import dei.vlab.communication.dao.*;
import dei.vlab.communication.model.Message;
public class MessagesDaoTest extends BaseDaoTestCase {
	@Autowired
	private MessagesDao dao;
	@Test
	public void testMessageById() throws Exception{
		Message mess = dao.get(1L);
		 assertNotNull(mess);
		
		}
}
