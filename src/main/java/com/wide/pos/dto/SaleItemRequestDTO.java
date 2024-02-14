package com.wide.pos.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SaleItemRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3191858594426627062L;
	@Range(min = 1)
	private int itemId;
	
	@Range(min = 1)
	private int quantity;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
