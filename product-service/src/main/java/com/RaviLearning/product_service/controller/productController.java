package com.RaviLearning.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RaviLearning.product_service.model.productRequest;
import com.RaviLearning.product_service.model.productResponce;
import com.RaviLearning.product_service.service.ProductService;

@RestController
@RequestMapping(value = "/api/product")
public class productController {

	@Autowired
	private ProductService productService;

	@PostMapping("/createProduct")
	public void createProduct(@RequestBody productRequest productRequest) {
		productService.creatProduct(productRequest);
	}
	
	
	@GetMapping("/getAllProducts")
	public List<productResponce> getAllProducts(){
		return productService.getAllProducts();
	}
}
