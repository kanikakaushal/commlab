package dei.vlab.communication.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import dei.vlab.communication.dao.MessagesDao;

import dei.vlab.communication.model.Message;
import dei.vlab.communication.model.User;

@Repository("messageDao")
public class MessagesDaoHibernate extends GenericDaoHibernate<Message, Long> implements MessagesDao {

	/*
	 * Constructor that set the entity to Messages.class.
	 */

	public MessagesDaoHibernate(){
		super(Message.class);
	}

	/*
	 * {@inheritDoc}
	 * (non-Javadoc)
	 * @see dei.vlab.communication.dao.MessagesDao#getMessage()
	 */

	public List<Message> getMessage(Long userid) {
		// TODO Auto-generated method stub
		return  getHibernateTemplate().find("from Messages m order by upper(m.message)");
	}
	
	
	
	
	
}
