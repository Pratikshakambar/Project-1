package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "orders_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_order",nullable = false)
	private Date dateOfOrder;

	@Column(name = "total_price",nullable = false)
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "shopping_id")
	private ShoppingCart shopping;

	@OneToMany(mappedBy = "productId")
	private List<Product> product = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "paymentDetails")
	private PaymentDetails paymentDetails;

//	not sure about onetoone
	@ElementCollection
	@CollectionTable(name = "Shipping_Address", joinColumns = @JoinColumn(name="order_id"))
	@Column(name = "shipping_address")
	private List<Address> shippingAddress = new ArrayList<>();

	public Order() {
		System.out.println("in constr of "+getClass().getName());
		
	}

	public Order(Date dateOfOrder, Double price) {
		super();
		this.dateOfOrder = dateOfOrder;
		this.price = price;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCart getShopping() {
		return shopping;
	}

	public void setShopping(ShoppingCart shopping) {
		this.shopping = shopping;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public List<Address> getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(List<Address> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", dateOfOrder=" + dateOfOrder + ", price=" + price + "]";
	}



	
}
