package com.RaviLearning.Inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.RaviLearning.Inventory_service.model.Inventory;
import com.RaviLearning.Inventory_service.repository.Inventoryrepository;

@SpringBootApplication
//@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(Inventoryrepository inventoryrepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Iphone-13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone-13-red");
			inventory1.setQuantity(0);

			inventoryrepository.save(inventory);
			inventoryrepository.save(inventory1);
		};
	}

}
