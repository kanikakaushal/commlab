/**
 * 
 */
package dei.vlab.communication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Message extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String too;
	private String ccc;
	@Column(length=100)
	private String subject;
	@Column(length=100,nullable=false)
	private String status;
	@ManyToOne
	@JoinColumn(name="userDetail_id")
	private UserDetail userdetail;
	
	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}

	
	public String getToo() {
		return too;
	}

	public void setToo(String too) {
		this.too = too;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		 return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
         .append(this.too)
         .append(this.status)
         
         .toString();

	}

	@Override
	public boolean equals(Object o) {
		 if (this == o) {
	            return true;
	        }
	        if (!(o instanceof Role)) {
	            return false;
	        }

	        final Message mess = (Message) o;

	        return !(too != null ? !too.equals(mess.too) : mess.too != null);


	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (too!=null ? too.hashCode() : 0);
	}

}
