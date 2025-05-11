package com.RaviLearning.Inventory_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RaviLearning.Inventory_service.model.Inventory;

public interface Inventoryrepository extends JpaRepository<Inventory, Long> {

	@Query(value="SELECT * FROM Inventory  WHERE sku_code = :skuCode",nativeQuery = true)
	List<Inventory> findBySkucode(@Param("skuCode") String skuCode);

}
