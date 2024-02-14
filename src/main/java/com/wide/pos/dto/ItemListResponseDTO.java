package com.wide.pos.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemListResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4254929782199365444L;

	private int id;

	private String itemCode;

	private String description;
	
	@JsonProperty(value = "istaxable")
	private boolean istaxable;

	private Integer price;

	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIstaxable() {
		return istaxable;
	}

	public void setIstaxable(boolean istaxable) {
		this.istaxable = istaxable;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
