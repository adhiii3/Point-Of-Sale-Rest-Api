package com.wide.pos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wide.pos.domain.Item;
import com.wide.pos.domain.Sale;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	public Optional<Item> findById(int id);
}
