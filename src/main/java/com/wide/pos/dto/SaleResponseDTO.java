package com.wide.pos.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SaleResponseDTO {
	
	private int id;
	
	private String namaKasir;
	
	private LocalDate tanggalTransaksi;
	
	private String jenisPembayaran;
	
	private int totalPrice;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaKasir() {
		return namaKasir;
	}

	public void setNamaKasir(String namaKasir) {
		this.namaKasir = namaKasir;
	}

	public LocalDate getTanggalTransaksi() {
		return tanggalTransaksi;
	}

	public void setTanggalTransaksi(LocalDate tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}

	public String getJenisPembayaran() {
		return jenisPembayaran;
	}

	public void setJenisPembayaran(String jenisPembayaran) {
		this.jenisPembayaran = jenisPembayaran;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
