package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "shopping_cart_tbl")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "quantity",nullable = false)
	private int quantity;
	
	@Column(name = "price",nullable = false)
	private double price;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany
	@JoinColumn(name = "product_id")
	private List<Product> product = new ArrayList<>();
	
	public ShoppingCart() {
		System.out.println("in default const of :"+getClass().getName());
	}

	public ShoppingCart(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
