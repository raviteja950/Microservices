package com.RaviLearning.product_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RaviLearning.product_service.model.Product;
import com.RaviLearning.product_service.model.productRequest;
import com.RaviLearning.product_service.model.productResponce;
import com.RaviLearning.product_service.repository.productRepository;

@Service
public class ProductService {

	@Autowired
	private productRepository productRepository;

	public void creatProduct(productRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		productRepository.save(product);
	}

	public List<productResponce> getAllProducts() {

		List<Product> product = productRepository.findAll();
		List<productResponce> listProductResponce = new ArrayList<productResponce>();

//		we can you stream here
//		product.stream().map(product -> mapToProductResponce())

		for (Product data : product) {
			productResponce productResponce = new productResponce();
			productResponce.setId(data.getId());
			productResponce.setName(data.getName());
			productResponce.setDescription(data.getDescription());
			productResponce.setPrice(data.getPrice());
			listProductResponce.add(productResponce);
		}

		return listProductResponce;

	}

}
