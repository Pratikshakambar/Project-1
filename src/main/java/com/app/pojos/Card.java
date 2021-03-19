package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Card {

	@Column(name = "card_no")
	private long cardNo;
	
	@Column(name = "card_holder_name", length = 30)
	private String cardHolderName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "card_expiry_date")
	private LocalDate cardExpiryDate;
	
	@Column(name = "card_cvv")
	private int cardCvv;
	
	public Card() {
		System.out.println("in card default const : "+getClass().getName());
	}

	public Card(long cardNo, String cardHolderName, LocalDate cardExpiryDate, int cardCvv) {
		super();
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.cardExpiryDate = cardExpiryDate;
		this.cardCvv = cardCvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}



	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(LocalDate cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public int getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}

	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", cardHolderName=" + cardHolderName + ", cardExpiryDate=" + cardExpiryDate
				+ ", cardCvv=" + cardCvv + "]";
	}

	
}