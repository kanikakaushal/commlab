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

public interface MessageDao extends GenericDao<Message, Long> {
    /*
     * Get Message from message table by user id
     */
    List findMessageById(Long id);
    
    /*
     * Get list of message from message table
     */

    List findAllMessage();

    /*
     * Save message
     */
    Message saveMessage(Message message);

    /*
     * Delete message
     */
    void deletMessageById(Long id);
}
