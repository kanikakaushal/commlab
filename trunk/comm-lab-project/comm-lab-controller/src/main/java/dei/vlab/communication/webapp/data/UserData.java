package dei.vlab.communication.webapp.data;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dei.vlab.communication.model.Role;

public class UserData implements Serializable {

	private static final long serialVersionUID = -679641873197524041L;
	private Integer id;
	private Integer sno;
	private String fullName;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String address1;
	private String address2;
	private String street;
	private String city;
	private String country;
	private String college;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "UserData ( "
	        + super.toString() + TAB
	        + "id = " + this.id + TAB
	        + "sno = " + this.sno + TAB
	        + "fullName = " + this.fullName + TAB
	        + "firstName = " + this.firstName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "email = " + this.email + TAB
	        + "contactNo = " + this.contactNo + TAB
	        + "address1 = " + this.address1 + TAB
	        + "address2 = " + this.address2 + TAB
	        + "street = " + this.street + TAB
	        + "city = " + this.city + TAB
	        + "country = " + this.country + TAB
	        + "college = " + this.college + TAB
	        + "status = " + this.status + TAB
	        + " )";
	
	    return retValue;
	}

	

}
