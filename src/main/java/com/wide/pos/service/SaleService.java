package com.wide.pos.service;

import java.util.List;

import com.wide.pos.domain.Sale;
import com.wide.pos.dto.SaleCreateRequestDTO;
import com.wide.pos.dto.SaleDetailResponseDTO;
import com.wide.pos.dto.SaleResponseDTO;

public interface SaleService {

	public SaleDetailResponseDTO findSaleById(int id);
	
	public List<SaleResponseDTO> findSaleAll();
}
