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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author server
 *
 */
@Entity
@Table(name="user_detail")
public class UserDetail extends BaseObject {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_detailid")
	private Long userDetailId;
	@MapsId("userDetailuseIdPk")
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="first_name",nullable=false,length=50,unique=true)
	private String firstNmae;
	@Column(name="last_name",nullable=false,length=50,unique=true)
	private String lastName;
	@Column(name ="email_address",length=100,nullable=false,unique=true)
	private String emailAddress;
	@Column(name="contact_no",length=12,unique=true)
	private String contactNumber;
	@Column(name="address1",length=200)
	private String address1;
	@Column(name="address2",length=200)
	private String address2;
	@Column(name="street",length=50)
	private String street;
	@Column(name="city",length=50)
	private String city;
	@Column(name="country",length=10)
	private String country;
	@Column(name="college_name",length=100)
	private String collegeNmae;
	
	@OneToOne
	@JoinColumn(name="messagesId")
	private Messages message;
	

	/**
	 * 
	 */
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}

	

	public Long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstNmae() {
		return firstNmae;
	}

	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
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

	public String getCollegeNmae() {
		return collegeNmae;
	}

	public void setCollegeNmae(String collegeNmae) {
		this.collegeNmae = collegeNmae;
	}

	public Messages getMessage() {
		return message;
	}

	public void setMessage(Messages message) {
		this.message = message;
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
