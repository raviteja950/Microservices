package com.RaviLearning.Inventory_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RaviLearning.Inventory_service.model.Inventory;
import com.RaviLearning.Inventory_service.model.InventoryResponce;
import com.RaviLearning.Inventory_service.repository.Inventoryrepository;

@Service
public class InventoryService {

	@Autowired
	private Inventoryrepository inventoryrepository;

	@Transactional(readOnly = true)
	public List<InventoryResponce> isInStock(List<String> skucode) {

		List<InventoryResponce> responceList = new ArrayList<>();

		for (String code : skucode) {
			List<Inventory> result = inventoryrepository.findBySkucode(code);

			for (Inventory data : result) {
				InventoryResponce responce = new InventoryResponce();
				responce.setSkuCode(data.getSkuCode());
				if (data.getQuantity() > 0) {
					responce.setInStock(true);
				}
				responceList.add(responce);
			}
		}
		return responceList;
	}
}
