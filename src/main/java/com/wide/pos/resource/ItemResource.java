package com.wide.pos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wide.pos.dto.ItemCreateRequestDTO;
import com.wide.pos.dto.ItemListResponseDTO;
import com.wide.pos.service.ItemService;

@RestController
public class ItemResource {
	
	private final ItemService itemService;

	public ItemResource(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping("/item")
	public ResponseEntity<Void> createNewItem(@RequestBody ItemCreateRequestDTO dto){
		itemService.createNewItem(dto);
		System.out.println(dto.istaxable());
		System.out.println(dto.getDescription());
		return ResponseEntity.created(URI.create("/item")).build();
	}
	
	@GetMapping("/item")
	public ResponseEntity<List<ItemListResponseDTO>> findAll(){
		return ResponseEntity.ok().body(itemService.findItems());
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Void> updateItem(@RequestBody ItemListResponseDTO dto, @PathVariable int id){
		itemService.updateItem(dto,id);
		return ResponseEntity.ok().build();
	}
}
