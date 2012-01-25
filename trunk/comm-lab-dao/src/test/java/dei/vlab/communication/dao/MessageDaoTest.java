/**
 * 
 */
package dei.vlab.communication.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

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

    @Test
    @Rollback(false)
    public void testSaveMessage() {
        Message message = new Message();
        message.setToo("abc@dei.co.in");
        message.setCcc("vlab@dei.ac.in");
        message.setStatus("V good ");
        message.setSubject("About Vlab Communication");
        messageDao.saveMessage(message);
        //Assert.assertNotNull("id is primary kee ", message.getId());
        flush();

    }

    @Test
    public void testFindeAllMessage() {
        List allMessage = messageDao.findAllMessage();
        assertNotNull("message", allMessage);
        System.out.println("all message "+allMessage);
    }
    
    @Test
    public void testFindeMessageById() {
        List messageById = messageDao.findMessageById(1L);
        		assertNotNull("message", messageById);
        System.out.println("Message by Id "+messageById);
    }

    @Test
    public void testDeleteMessageById() {
        messageDao.deletMessageById(1L);
        System.out.println("Delete Message");
    }

}
