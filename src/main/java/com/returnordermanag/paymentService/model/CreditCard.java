package com.returnordermanag.paymentService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class CreditCard {

	@Id
	private long cardNumber;
	private double cardLimit;
	
	public CreditCard() {
	}
	
	public CreditCard(long cardNumber, double cardLimit) {
		this.cardNumber = cardNumber;
		this.cardLimit = cardLimit;
	}
		
}
