package com.wide.pos.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentCheckoutRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7614998601799986265L;

	private int amount;
	
	private String type;
	
	private int cashInHand;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCashInHand() {
		return cashInHand;
	}

	public void setCashInHand(int cashInHand) {
		this.cashInHand = cashInHand;
	}
	
	
}
