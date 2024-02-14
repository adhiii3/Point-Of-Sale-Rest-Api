package com.wide.pos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wide.pos.domain.Item;
import com.wide.pos.dto.ItemCreateRequestDTO;
import com.wide.pos.dto.ItemListResponseDTO;
import com.wide.pos.repository.ItemRepository;
import com.wide.pos.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void createNewItem(ItemCreateRequestDTO dto) {
		
		Item item = new Item();
		item.setItemCode(dto.getItemCode());
		item.setDescription(dto.getDescription());
		item.setPrice(dto.getPrice());
		item.setTaxable(dto.istaxable());
		item.setType(dto.getType());
		
		itemRepository.save(item);
	}

	@Override
	public List<ItemListResponseDTO> findItems() {
		List<ItemListResponseDTO> itemsDto = itemRepository.findAll().stream()
				.map((item) -> {
					ItemListResponseDTO dto = new ItemListResponseDTO();
					dto.setId(item.getId());
					dto.setDescription(item.getDescription());
					dto.setIstaxable(item.isTaxable());
					dto.setItemCode(item.getItemCode());
					dto.setPrice(item.getPrice());
					dto.setType(item.getType());
					return dto;
				}).collect(Collectors.toList());
		return itemsDto;
	}

	@Override
	public void updateItem(ItemListResponseDTO dto,int id) {
		Item item = itemRepository.findById(id).orElse(new Item());
		
		if(item.getId() != 0) {
			item.setDescription(dto.getDescription() == null ? item.getDescription() : dto.getDescription());
			item.setItemCode(dto.getItemCode() == null ? item.getItemCode() : dto.getItemCode());
			item.setPrice(dto.getPrice() == null ? item.getPrice() : dto.getPrice());
			
			if(dto.isIstaxable()) {
				item.setTaxable(true);
			}else {
				item.setTaxable(false);
			}
			item.setType(dto.getType() == null ? item.getType() : dto.getType());
			itemRepository.save(item);
		}
		
	}

	@Override
	public ItemListResponseDTO findItemById(int id) {
		Item item = itemRepository.findById(id).orElse(new Item());
		ItemListResponseDTO dto = new ItemListResponseDTO();
	
		dto.setId(item.getId());
		dto.setDescription(item.getDescription());
		dto.setIstaxable(item.isTaxable());
		dto.setItemCode(item.getItemCode());
		dto.setPrice(item.getPrice());
		dto.setType(item.getType());
		
		return dto;
	}

}
