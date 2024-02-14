package com.wide.pos.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.wide.pos.domain.Cashier;

public class SaleCreateRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3217262353733733099L;

	private String salesNumber;
	
	private LocalDate transDate;
	
	private Cashier cashier;
}
