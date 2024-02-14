package com.wide.pos.service;

import java.util.List;

import com.wide.pos.domain.Item;
import com.wide.pos.dto.ItemCreateRequestDTO;
import com.wide.pos.dto.ItemListResponseDTO;

public interface ItemService {
	
	public void createNewItem(ItemCreateRequestDTO dto);
	
	public List<ItemListResponseDTO> findItems();
	
	public ItemListResponseDTO findItemById(int id);
	
	public void updateItem(ItemListResponseDTO dto, int id);
}
