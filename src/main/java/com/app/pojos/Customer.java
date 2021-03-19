package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "customer_tbl")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int customerId;
	
	@Column(name = "name", length = 20,nullable = false)
	private String name;
	
	@Column(name = "email", length = 20,nullable = false, unique = true)
	private String email;
	
	@Column(name = "mobile_no", length = 20, nullable = false, unique = true)
	private String mobileNo;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;
	
	//not sure onetoone or onetomany
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Address> address;
	
	//1 Customer has 1 cart
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	private ShoppingCart shoppingCart;

	//1 customer can have list of orders
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order> order=new ArrayList<>();
	
	//1 Customer has only 1 wish list
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private WishList wishList;
	
	//one to one bi-dir mapping between Customer(Entity) 1<--->1 PaymentDetails(Entity) 
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private PaymentDetails paymentDetails;
	
	public Customer() {
		System.out.println(" in customer default const : "+getClass().getName());
	}

	public Customer(String name, String email, String mobileNo, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}
	
	
}
