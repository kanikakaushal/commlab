package dei.vlab.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name="user_detail")
public class UserDetail extends BaseObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User uid;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	private String firsName;
	private String lastName;
	private String emailAddress;
	private Long contactNumber;
	private String address1;
	private String address2;
	private String street;
	private String city;
	private String country;
	private String collegeName;
	
		
	public UserDetail() {
		
	}
	
	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public Long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	

	@Override
	public String toString() {
		  return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
          .append(this.firsName)
          .append(this.lastName)
          .append(this.address1)
          .append(this.address2)
          .append(this.collegeName)
          .append(this.city)
          .append(this.emailAddress)
          
          .toString();
	}

	@Override
	public boolean equals(Object o) {
		 if (this == o) {
	            return true;
	        }
	        if (!(o instanceof UserDetail)) {
	            return false;
	        }

	        final UserDetail userDetail = (UserDetail) o;

	        return !(firsName != null ? !firsName.equals(userDetail.firsName) : userDetail.firsName != null);

	}

	@Override
	public int hashCode() {
		 return (firsName != null ? firsName.hashCode() : 0);
	}

}
