package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class NetBanking {

	@Column(name = "user_id",length = 30)
	private String userId;
	
	@Column(length = 20)
	private String pin;
	
	public NetBanking() {
		System.out.println("in netbanking default constr : "+getClass().getName());
	}

	public NetBanking(String userId, String pin) {
		super();
		this.userId = userId;
		this.pin = pin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "NetBanking [userId=" + userId + ", pin=" + pin + "]";
	}
	
}