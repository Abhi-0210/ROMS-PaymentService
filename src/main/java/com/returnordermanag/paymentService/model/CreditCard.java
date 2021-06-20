package com.returnordermanag.paymentService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Entity
@Data
@ApiModel(description="Credit Card Model")
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
