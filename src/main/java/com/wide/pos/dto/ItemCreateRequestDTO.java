package com.wide.pos.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemCreateRequestDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5334278135411505115L;
	
	@NotBlank
	private String itemCode;
	
	@NotBlank
	private String description;
	
	@NotBlank
	@JsonProperty(value = "istaxable")
	private boolean istaxable;
	
	@Min(value = 1, message = "Price must be minimal 1")
	private Integer price;
	
	@NotBlank
	private String type;

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

	public boolean istaxable() {
		return istaxable;
	}

	public void istaxable(boolean istaxable) {
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
