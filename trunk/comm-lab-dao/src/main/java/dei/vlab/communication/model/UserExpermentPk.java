package dei.vlab.communication.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserExpermentPk extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userExpermentUserIdPk;
	private Long userExpermentCircuitIdPk;
	private Long userExpermentExpermentIdPk;
	public Long getUserExpermentUserIdPk() {
		return userExpermentUserIdPk;
	}
	public void setUserExpermentUserIdPk(Long userExpermentUserIdPk) {
		this.userExpermentUserIdPk = userExpermentUserIdPk;
	}
	public Long getUserExpermentCircuitIdPk() {
		return userExpermentCircuitIdPk;
	}
	public void setUserExpermentCircuitIdPk(Long userExpermentCircuitIdPk) {
		this.userExpermentCircuitIdPk = userExpermentCircuitIdPk;
	}
	public Long getUserExpermentExpermentIdPk() {
		return userExpermentExpermentIdPk;
	}
	public void setUserExpermentExpermentIdPk(Long userExpermentExpermentIdPk) {
		this.userExpermentExpermentIdPk = userExpermentExpermentIdPk;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
