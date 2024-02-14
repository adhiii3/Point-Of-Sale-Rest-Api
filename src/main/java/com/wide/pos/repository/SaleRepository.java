package com.wide.pos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wide.pos.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{
//	public void save(Sale sale);
	public Optional<Sale> findById(Integer saleId);
//	public List<Sale> findAll();
}
