package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_mode",nullable = false)
	private PaymentMode paymentMode;
	
	@Column(name = "payment_date",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@Column(name = "payment_amount",nullable = false)
	private double paymentAmount;
	
	@Column(length = 30,name = "payment_status",nullable = false)
	private String paymentStatus;
	
	@Embedded
	private Card cardDetails;
	
	@Embedded
	private NetBanking netBankingDetails;
	
	@OneToOne
	private Customer customer;
	
	public PaymentDetails() {
		System.out.println("in payment details default const : "+getClass().getName());
	}

	public PaymentDetails(int paymentId, PaymentMode paymentMode, LocalDate paymentDate, double paymentAmount,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Card getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	public NetBanking getNetBankingDetails() {
		return netBankingDetails;
	}

	public void setNetBankingDetails(NetBanking netBankingDetails) {
		this.netBankingDetails = netBankingDetails;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentDate="
				+ paymentDate + ", paymentAmount=" + paymentAmount + ", paymentStatus=" + paymentStatus + "]";
	}
}