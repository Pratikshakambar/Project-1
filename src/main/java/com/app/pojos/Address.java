package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "address_tbl")
public class Address {
	//a comment to check git push
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "address_1", length = 100,nullable = false)
	private String addressLine1;
	
	@Column(name = "address_2", length = 100)
	private String addressLine2;
	
	@Column(length = 20,nullable = false)
	private String city;
	
	@Column(length = 20,nullable = false)
	private String country;
	
	@Column(nullable = false)
	private int pincode;
	

	@Column(nullable = false)
	private int pincode2;
	
	//bi-dir mapping between Address(Entity) *<--->1vCustomer(Entity) 
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Address() {
		System.out.println("in default const  of : "+getClass().getName());
	}

	public Address(String addressLine1, String addressLine2, String city, String country, int pincode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", country=" + country + ", pincode=" + pincode + "]";
	}



	

}
