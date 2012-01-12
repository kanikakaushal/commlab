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
@Table(name = "message")
public class Message extends BaseObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String too;
    private String ccc;

    private String subject;

    private String status;

    private UserDetail userdetail;

    /**
	 * 
	 */
    public Message() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(nullable = false)
    public String getToo() {
        return too;
    }

    @Column(length = 100)
    public String getSubject() {
        return subject;
    }

    @Column(length = 100, nullable = false)
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "userDetail_id")
    public UserDetail getUserdetail() {
        return userdetail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserdetail(UserDetail userdetail) {
        this.userdetail = userdetail;
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.too).append(this.status)

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
        return (too != null ? too.hashCode() : 0);
    }

}
