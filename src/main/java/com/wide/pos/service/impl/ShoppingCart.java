package com.wide.pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wide.pos.domain.CashPayment;
import com.wide.pos.domain.Cashier;
import com.wide.pos.domain.Item;
import com.wide.pos.domain.Payment;
import com.wide.pos.domain.QrisPayment;
import com.wide.pos.domain.Sale;
import com.wide.pos.domain.SaleItem;
import com.wide.pos.dto.ItemListResponseDTO;
import com.wide.pos.dto.PaymentCheckoutRequestDTO;
import com.wide.pos.dto.SaleCheckoutResponseDTO;
import com.wide.pos.dto.SaleItemResponseDTO;
import com.wide.pos.repository.SaleRepository;
import com.wide.pos.service.ItemService;

@Component
public class ShoppingCart {

	private ItemService itemService;
	
	private SaleRepository saleRepository;
	
	private Sale sale;

	public ShoppingCart(ItemService itemService, SaleRepository saleRepository) {
		this.itemService = itemService;
		this.saleRepository = saleRepository;
	}
	
	public void createNewSale() {
		this.sale = new Sale(new Cashier("c-1","ira"));
	}
	
	public void addSaleItem(int itemId,int quantity){
		ItemListResponseDTO itemDto = itemService.findItemById(itemId);
		Item item = new Item(itemDto.getId(),itemDto.getItemCode() , itemDto.getPrice(), itemDto.getDescription(), itemDto.getType(),itemDto.isIstaxable());
		
		SaleItem saleItem = new SaleItem(quantity,item);
		saleItem.setSale(sale);
		this.sale.addSaleItem(saleItem);
	}
	
	public void makePayment(PaymentCheckoutRequestDTO dto) {
		Payment payment;
		if("cash".equalsIgnoreCase(dto.getType())) {
			payment = new CashPayment(dto.getCashInHand(),this.getSale().getTotalPricePlusTotalTax());
			this.sale.setPayment(payment);
			return;
		}else {
			payment = new QrisPayment(this.getSale().getTotalPricePlusTotalTax());
			this.sale.setPayment(payment);
			return;
		}
	}
	
	public Sale getSale() {
		return this.sale;
	}
	
	public void finishSale() {
			saleRepository.save(this.getSale());
	}
	
	public void clearSale() {
		this.sale = null;
	}
	
	public SaleCheckoutResponseDTO findAllSaleItem(){
		Sale sale = this.getSale();
		
		SaleCheckoutResponseDTO dto1 = new SaleCheckoutResponseDTO();
		dto1.setSaleNumber(sale.getSalesNumber());
		dto1.setNamaKasir(sale.getCashier().getName());
		dto1.setSaleDate(sale.getTransDate());

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
		
		dto1.setSaleItem(saleItems);
		dto1.setTotalHargaSaleItem(sale.getTotalPrice());
		dto1.setTax(sale.getTotalTax());
		dto1.setTotalPembayaran(sale.getTotalPricePlusTotalTax());
		
		
		return dto1;
	}
	
}
