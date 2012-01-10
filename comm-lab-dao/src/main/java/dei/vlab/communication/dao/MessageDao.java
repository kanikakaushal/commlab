/**
 * 
 */
package dei.vlab.communication.dao;

import java.util.List;

import dei.vlab.communication.model.Message;

/**
 * @author server
 *
 */
public interface MessageDao extends GenericDao<Message, Long>{
	/*
	 * Get Message from message table by user id
	 */
	Message getMessagesById(Long messageId);
	/*
	 * Get list of  message from message table
	 */

	List getMessage();
	/*
	 * save message 
	 */
	Message saveMessage(Message messageId);
	/*
	 * Delete message
	 */
	void deletMessage(Long messageid);
}
