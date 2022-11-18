package application;

import java.io.Serializable;

public class Customer implements Serializable{
	public String firstname;
	public String lastname;
	public int customerid;
	public String street;
	public String city;
	public String houseno;
	public String postcode;
	public String email;
	
	
	


	public Customer(String firstname,String lastname, int customerid, String street, String city, String houseno, String postcode,
			String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerid = customerid;
		this.street = street;
		this.city = city;
		this.houseno = houseno;
		this.postcode = postcode;
		this.email = email;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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


	public String getHouseno() {
		return houseno;
	}


	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
