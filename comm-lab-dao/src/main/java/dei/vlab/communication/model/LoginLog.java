package dei.vlab.communication.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Generated;

@Entity
@Table(name="login_log")
public class LoginLog  extends BaseObject{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	private Long sessionId;
	private Timestamp loginAt;
	private String sessionlog;
	
	public LoginLog() {
		// TODO Auto-generated constructor stub
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getSessionId() {
		return sessionId;
	}



	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}



	public Timestamp getLoginAt() {
		return loginAt;
	}



	public void setLoginAt(Timestamp loginAt) {
		this.loginAt = loginAt;
	}



	public String getSessionlog() {
		return sessionlog;
	}



	public void setSessionlog(String sessionlog) {
		this.sessionlog = sessionlog;
	}


	@Override
	public String toString() {
		  return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
          .append(this.sessionlog)
          .toString();
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o) {
	            return true;
	        }
	        if (!(o instanceof LoginLog)) {
	            return false;
	        }

	        final LoginLog loginLog = (LoginLog) o;

	        return !(sessionlog != null ? !sessionlog.equals(LoginLog.class) :  loginLog.sessionlog!= null);

	}

	@Override
	public int hashCode() {
		return ( sessionlog!= null ? sessionlog.hashCode() : 0);
	}

}
