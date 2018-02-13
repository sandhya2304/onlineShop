package com.myecom.onshop_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter address line one!")
	@Column(name = "address_line_one")
	private String addressLineOne;
	@NotBlank(message = "Please enter address line two!")	
	@Column(name = "address_line_two")
	private String addressLineTwo;
	@NotBlank(message = "Please enter City!")	
	private String city;
	@NotBlank(message = "Please enter State!")	
	private String state;
	@NotBlank(message = "Please enter country!")	
	private String country;
	@Column(name ="postal_code")
	@NotBlank(message = "Please enter Postal Code!")	
	private String postalCode;
	@Column(name="is_shipping")
	private boolean shipping;
	@Column(name="is_billing")
	private boolean billing;
	
	
	/*@Column(name = "user_id")
	public int userId;

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}*/

    @ManyToOne
	public User user;
	
	
	public Address(String addressLineOne, String addressLineTwo, String city, String state, String country,
			String postalCode, boolean shipping, boolean billing) {
		super();
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.shipping = shipping;
		this.billing = billing;
	}
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	
	

}
