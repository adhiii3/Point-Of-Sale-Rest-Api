package com.wide.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wide.pos.domain.CashPayment;
import com.wide.pos.domain.Cashier;
import com.wide.pos.domain.Item;
import com.wide.pos.domain.Payment;
import com.wide.pos.domain.Sale;
import com.wide.pos.domain.SaleItem;
import com.wide.pos.dto.ItemListResponseDTO;
import com.wide.pos.dto.PaymentCheckoutRequestDTO;
import com.wide.pos.dto.SaleCheckoutResponseDTO;
import com.wide.pos.dto.SaleDetailResponseDTO;
import com.wide.pos.dto.SaleItemResponseDTO;
import com.wide.pos.dto.SaleResponseDTO;
import com.wide.pos.repository.SaleRepository;
import com.wide.pos.service.ItemService;
import com.wide.pos.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService{

	private SaleRepository saleRepository;

	public SaleServiceImpl(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	@Override
	public SaleDetailResponseDTO findSaleById(int id) {
		Sale sale = saleRepository.findById(id).orElse(new Sale());

		List<SaleItemResponseDTO> saleItems = sale.getSaleItem().stream().map((s)->{
			SaleItemResponseDTO dt = new SaleItemResponseDTO();
			dt.setItemCode(s.getItem().getItemCode());
			dt.setDescription(s.getItem().getDescription());
			dt.setIstaxable(s.getItem().isTaxable());
			dt.setPrice(s.getItem().getPrice());
			dt.setQuantity(s.getQuantity());
			dt.setTotalPrice(s.getTotalPrice());
			dt.setType(s.getItem().getType());
			return dt;
		}).collect(Collectors.toList());
		
		
		PaymentCheckoutRequestDTO paymentDto = new PaymentCheckoutRequestDTO();
		
		if("cash".equalsIgnoreCase(sale.getPayment().getType())) {
			paymentDto.setType(sale.getPayment().getType());
			paymentDto.setCashInHand(((CashPayment) sale.getPayment()).getCashInHand());
			paymentDto.setAmount(sale.getPayment().getAmount());
		}else {
			paymentDto.setType(sale.getPayment().getType());
			paymentDto.setCashInHand(0);
			paymentDto.setAmount(sale.getPayment().getAmount());
		}
		
		SaleDetailResponseDTO dto1 = new SaleDetailResponseDTO();
		
		dto1.setSaleNumber(sale.getSalesNumber());
		dto1.setNamaKasir(sale.getCashier().getName());
		dto1.setSaleDate(sale.getTransDate());
		dto1.setSaleItem(saleItems);
		dto1.setTotalHargaSaleItem(sale.getTotalPrice());
		dto1.setTax(sale.getTotalTax());
		dto1.setTotalPembayaran(sale.getTotalPricePlusTotalTax());
		dto1.setPaymentCheckout(paymentDto);
		
		return dto1;
	}

	@Override
	public List<SaleResponseDTO> findSaleAll() {
	List<SaleResponseDTO> sales = saleRepository.findAll().stream().map((s) -> {
			SaleResponseDTO dto = new SaleResponseDTO();
			dto.setId(s.getId());
			dto.setNamaKasir(s.getCashier().getName());
			dto.setTanggalTransaksi(s.getTransDate());
			dto.setJenisPembayaran(s.getPayment().getType());
			dto.setTotalPrice(s.getTotalPricePlusTotalTax());
			
			return dto;
		}).collect(Collectors.toList());
		
		return sales;
	}
	
}
