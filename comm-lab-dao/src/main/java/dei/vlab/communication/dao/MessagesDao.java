package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.Message;

/*
 * User Messages Access interface.
 */
public interface MessagesDao extends GenericDao<Message, Long> {
	/*
	 * Get a list of user messages according to the  username
	 */
	
	List<Message> getMessage(Long userid);
	
	

}
