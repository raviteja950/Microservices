package com.RaviLearning.order_service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.RaviLearning.order_service.config.WebclientConfig;
import com.RaviLearning.order_service.model.InventoryResponce;
import com.RaviLearning.order_service.model.OderLineItems;
import com.RaviLearning.order_service.model.Order;
import com.RaviLearning.order_service.model.OrderRequest;
import com.RaviLearning.order_service.model.orderLineitemsDto;
import com.RaviLearning.order_service.repository.OderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OderRepository oderRepository;

	@Autowired
	private WebClient.Builder clientBuilder;

	public void placeOrder(OrderRequest orderRequest) {

		Order order = new Order();
		List<OderLineItems> oderLineItems = new ArrayList<OderLineItems>();

		order.setOrderNumber(UUID.randomUUID().toString());

		List<orderLineitemsDto> dtoList = orderRequest.getOrderLineItemsDtoList();

		for (orderLineitemsDto data : dtoList) {
			OderLineItems lineItems = new OderLineItems();
			lineItems.setPrice(data.getPrice());
			lineItems.setQuantity(data.getQuantity());
			lineItems.setSkuCode(data.getSkuCode());
			oderLineItems.add(lineItems);
		}
		order.setOderLineitems(oderLineItems);

		List<String> skucode = new ArrayList<String>();

		for (orderLineitemsDto data : dtoList) {
			skucode.add(data.getSkuCode());
		}

		// call inventory service and place order if product is present
		// Stock
		InventoryResponce[] InventoryResponceArray = clientBuilder.build().get()
				.uri("http://Inventory-service/api/inventory/isInStock",
						uriBuilder -> uriBuilder.queryParam("skuCode", skucode.toArray()).build())
				.retrieve().bodyToMono(InventoryResponce[].class).block();

		boolean allproductInStock = Arrays.stream(InventoryResponceArray).allMatch(InventoryResponce::isInStock);
		if (allproductInStock == true) {
			oderRepository.save(order);
		} else {
			System.out.println("False");
		}

	}
}
