package com.RaviLearning.Inventory_service.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RaviLearning.Inventory_service.service.InventoryService;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/isInStock/{sku-code}")
	public boolean isInStock(@PathVariable("sku-code") String skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
