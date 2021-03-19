package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
// customer--> has a --> wishlist - bi dire

@Entity
@Table(name="Wish_list")
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private int wishListId;
	
	//one wish list can contain many products
	@OneToMany
	private List<Product> product=new ArrayList<>();
	
	@OneToOne
	private Customer customer;
	
	public WishList() {
		System.out.println("in wishlist default const : "+getClass().getName());
	}

	public int getWishListId() {
		return wishListId;
	}

	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}

	

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "WishList [wishListId=" + wishListId + "]";
	}



}