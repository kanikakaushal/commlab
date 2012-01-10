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
		// TODO Auto-generated constructor stub
	}

	public Message getMessagesById(Long messageId) {
		Message message=null;
		try {
			System.out.println("hii  i  ma in the message dao hibenate");
			message = getHibernateTemplate().load(Message.class, messageId);
			if(message==null){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	public List getMessage() {
		List messageList= null;
		try {
			messageList= getHibernateTemplate().find("from message");
			if(messageList.isEmpty()){
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return messageList;
	}

	public Message saveMessage(Message messageId) {
		if(log.isDebugEnabled()){
			log.debug("Going for Saving Message id "+messageId);
		}
		try {
			getHibernateTemplate().saveOrUpdate(messageId);
			getHibernateTemplate().flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return messageId;
	}

	public void deletMessage(Long messageid) {
	   try {
		Object delmessage= getHibernateTemplate().load(Message.class, messageid);
		if(delmessage!=null){
			getHibernateTemplate().delete(delmessage);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}

}
