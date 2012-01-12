/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

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
    public void testMesssageById() {
        List message = messageDao.findMessageById(1L);
        assertNotNull(message);
    }
/* required spring modification
    @Test
    public void testSaveMessage() {
        Message message = null;
        message.setToo("abc@dei.co.in");
        message.setCcc("vlab@dei.ac.in");
        message.setStatus("V good ");
        message.setSubject("About Vlab Communication");
        messageDao.saveMessage(message);
        Assert.assertNotNull("id is primary kee ", message.getId());

    }

    @Test
    public void testFindeAllMessage() {
        List AllMessage = messageDao.findAllMessage();
        assertNotNull("message", AllMessage);
    }

    @Test
    public void testDeleteMessageById() {
        messageDao.deletMessageById(1L);
    }
*/
}
