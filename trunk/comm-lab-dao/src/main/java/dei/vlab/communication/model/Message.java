/**
 * 
 */
package dei.vlab.communication.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author server
 *
 */
@Entity
@Table(name="message")
public class Message extends BaseObject  {

	/*
	 * Default constructor - creat a new instance with no value set.
	 */
	public Message(){
		
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long messageId;
	private String subject;
	private String message;
	private String status;
	private Date date;
	
	@ManyToOne
	private User user;

	
	public Long getMessageId() {
		return messageId;
	}


	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	

	/* (non-Javadoc)
	 * @see dei.vlab.communication.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		ToStringBuilder sb =new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE).append("Message",this.message);
		if(message!=null){
			sb.append("Your Message is");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see dei.vlab.communication.model.BaseObject#equals(java.lang.Object)
	 * {@inheritDoc
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o){
			return true;
		}
		if(!(o instanceof Message)){
			return false;
		}
		final Message message =(Message) o;
		return !(messageId != null ? ! message.equals(getMessage()): message.getMessage()!=null);
		
	}

	/* (non-Javadoc)
	 * @see dei.vlab.communication.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
	return (message != null ? message.hashCode() : 0);
	}

}
