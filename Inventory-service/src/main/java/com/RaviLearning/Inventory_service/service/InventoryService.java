package com.RaviLearning.Inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RaviLearning.Inventory_service.repository.Inventoryrepository;

@Service
public class InventoryService {

	@Autowired
	private Inventoryrepository inventoryrepository;

	@Transactional(readOnly = true)
	public boolean isInStock(String skucode) {
		return inventoryrepository.findBySkucode(skucode).isPresent();
	}
}
