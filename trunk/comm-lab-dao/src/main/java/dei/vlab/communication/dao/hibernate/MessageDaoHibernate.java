/**
 * 
 */
package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.MessageDao;
import dei.vlab.communication.model.Message;

/**
 * @author server
 * 
 */
@Repository
public class MessageDaoHibernate extends GenericDaoHibernate<Message, Long> implements MessageDao {

    public MessageDaoHibernate() {
        super(Message.class);

    }

    public Message saveMessage(Message messageId) {
        if (log.isDebugEnabled()) {
            log.debug("Going for Saving Message id " + messageId);
        }
        getHibernateTemplate().saveOrUpdate(messageId);
        return messageId;
    }

    public List findMessageById(Long id) {
        List message = null;
        message = getHibernateTemplate().find("from Message where id=?", id);
        if (message == null) {
            return null;
        }
        return message;
    }

    public List findAllMessage() {
        List messageList = null;
        messageList = getHibernateTemplate().find("from Message");
        if (messageList.isEmpty()) {
            return null;
        }
        return messageList;
    }

    public void deletMessageById(Long id) {
        Object delmessage = getHibernateTemplate().load(Message.class, id);
        if (delmessage != null) {
            getHibernateTemplate().delete(delmessage);
        }

    }

}
