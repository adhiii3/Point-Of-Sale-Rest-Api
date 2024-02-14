package com.wide.pos.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wide.pos.domain.SaleItem;
import com.wide.pos.dto.ItemCreateRequestDTO;
import com.wide.pos.dto.PaymentCheckoutRequestDTO;
import com.wide.pos.dto.SaleCheckoutResponseDTO;
import com.wide.pos.dto.SaleDetailResponseDTO;
import com.wide.pos.dto.SaleItemRequestDTO;
import com.wide.pos.dto.SaleItemResponseDTO;
import com.wide.pos.service.SaleService;
import com.wide.pos.service.impl.ShoppingCart;

@RestController
@SessionAttributes("shoppingCart")
public class CartResource {

	@Autowired
	private ShoppingCart shoppingCart;

	private SaleService saleService;
	
	@ModelAttribute("shoppingCart")
	public ShoppingCart shoppingCart() {
		return this.shoppingCart;
	}
	
	@PostMapping("/cart")
	public ResponseEntity<Void> addSaleItem(@RequestBody SaleItemRequestDTO dto){
		if (shoppingCart.getSale() != null) {
			shoppingCart.addSaleItem(dto.getItemId(), dto.getQuantity());
		} else {
			shoppingCart.createNewSale();
			shoppingCart.addSaleItem(dto.getItemId(), dto.getQuantity());
		}
		
		return ResponseEntity.created(URI.create("/cart")).build();
	}
	
	@GetMapping("/cart")
	public ResponseEntity<SaleCheckoutResponseDTO> findSaleItems(){
		
		return ResponseEntity.ok().body(shoppingCart.findAllSaleItem());
	}
	
	@PostMapping("/cart/checkout")
	public ResponseEntity<Void> checkOutSale(@RequestBody PaymentCheckoutRequestDTO dto){
		shoppingCart.makePayment(dto);
		shoppingCart.finishSale();
		shoppingCart.clearSale();
		return ResponseEntity.created(URI.create("/cart/checkout")).build();
	}
	
}
