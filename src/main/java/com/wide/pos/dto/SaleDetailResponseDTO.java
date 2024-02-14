package com.wide.pos.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SaleDetailResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7366333381157968156L;
	
	private String saleNumber;
	
	private String namaKasir;
	
	private LocalDate saleDate;

	private List<SaleItemResponseDTO> saleItem;
	
	private int totalHargaSaleItem;
	
	private int tax;
	
	private int totalPembayaran;
	
	@JsonProperty(value = "payment")
	private PaymentCheckoutRequestDTO paymentCheckout;

	public String getSaleNumber() {
		return saleNumber;
	}

	public void setSaleNumber(String saleNumber) {
		this.saleNumber = saleNumber;
	}

	public String getNamaKasir() {
		return namaKasir;
	}

	public void setNamaKasir(String namaKasir) {
		this.namaKasir = namaKasir;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public List<SaleItemResponseDTO> getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(List<SaleItemResponseDTO> saleItem) {
		this.saleItem = saleItem;
	}

	public int getTotalHargaSaleItem() {
		return totalHargaSaleItem;
	}

	public void setTotalHargaSaleItem(int totalHargaSaleItem) {
		this.totalHargaSaleItem = totalHargaSaleItem;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTotalPembayaran() {
		return totalPembayaran;
	}

	public void setTotalPembayaran(int totalPembayaran) {
		this.totalPembayaran = totalPembayaran;
	}

	public PaymentCheckoutRequestDTO getPaymentCheckout() {
		return paymentCheckout;
	}

	public void setPaymentCheckout(PaymentCheckoutRequestDTO paymentCheckout) {
		this.paymentCheckout = paymentCheckout;
	}

	
	
}
