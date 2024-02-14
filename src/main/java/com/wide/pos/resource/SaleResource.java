package com.wide.pos.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wide.pos.dto.ItemListResponseDTO;
import com.wide.pos.dto.SaleDetailResponseDTO;
import com.wide.pos.dto.SaleResponseDTO;
import com.wide.pos.service.SaleService;

@RestController
public class SaleResource {

	private SaleService saleService;

	public SaleResource(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@GetMapping("sale")
	public ResponseEntity<List<SaleResponseDTO>> findAll(){
		return ResponseEntity.ok().body(saleService.findSaleAll());
	}
	
	@GetMapping("sale/{id}")
	public ResponseEntity<SaleDetailResponseDTO> findAl(@PathVariable int id){
		return ResponseEntity.ok().body(saleService.findSaleById(id));
	}
	
	
}
